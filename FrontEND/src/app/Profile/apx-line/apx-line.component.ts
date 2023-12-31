import {Component, ViewChild} from '@angular/core';
import {
  ChartComponent,
  ApexAxisChartSeries,
  ApexChart,
  ApexXAxis,
  ApexDataLabels,
  ApexStroke,
  ApexMarkers,
  ApexYAxis,
  ApexGrid,
  ApexTitleSubtitle,
  ApexLegend
} from "ng-apexcharts";
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

export type ChartOptions = {
  series: ApexAxisChartSeries;
  chart: ApexChart;
  xaxis: ApexXAxis;
  stroke: ApexStroke;
  dataLabels: ApexDataLabels;
  markers: ApexMarkers;
  tooltip: any; // ApexTooltip;
  yaxis: ApexYAxis;
  grid: ApexGrid;
  legend: ApexLegend;
  title: ApexTitleSubtitle;
};
@Component({
  selector: 'apx-line',
  templateUrl: './apx-line.component.html',
  styleUrls: ['./apx-line.component.css']
})
export class ApxLineComponent {
  @ViewChild("chart") chart!: ChartComponent;
  public chartOptions: Partial<ChartOptions> = {};
  transformedData: any[] = [];
  userskills: string[] = [];
  // @ts-ignore
  user: string = localStorage.getItem('user_id');
  constructor(private router: Router, private myApiService: MyApiService) {

    this.chartOptions = {
      series: [
        {
          name: "Session Duration",
          data: [45, 52, 38, 24, 33, 26, 21, 20, 6, 8, 15, 10,11]
        },
        {
          name: "Page Views",
          data: [35, 41, 62, 42, 13, 18, 29, 37, 36, 51, 32, 35,14]
        },
        {
          name: "Total Visits",
          data: [87, 57, 74, 99, 75, 38, 62, 47, 82, 56, 45, 47,15]
        }
      ],
      chart: {
        height: 350,
        type: "line"
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        width: 5,
        curve: "straight",
        dashArray: [0, 8, 5]
      },
      title: {
        text: "Employee Skills Statistic",
        align: "left"
      },
      legend: {
        tooltipHoverFormatter: function(val, opts) {
          return (
            val +
            " - <strong>" +
            opts.w.globals.series[opts.seriesIndex][opts.dataPointIndex] +
            "</strong>"
          );
        }
      },
      markers: {
        size: 0,
        hover: {
          sizeOffset: 6
        }
      },
      xaxis: {
        labels: {
          trim: false
        },
        categories: this.generateMonthCategories()
      },
      tooltip: {
        y: [
          {
            title: {
              formatter: function({val}: { val: any }) {
                return val + " (mins)";
              }
            }
          },
          {
            title: {
              formatter: function({val}: { val: any }) {
                return val + " per session";
              }
            }
          },
          {
            title: {
              formatter: function({val}: { val: any }) {
                return val;
              }
            }
          }
        ]
      },
      grid: {
        borderColor: "#f1f1f1"
      }
    };
  }

  ngOnInit() {
    this.getalluserSkills();
  }

  getalluserSkills() {
    this.myApiService.getalluserSKILLS(this.user).subscribe(data => {
      this.userskills = Array.from(new Set(data));
      this.getalldata();
    });
  }

  getGraph(userId: string, skillid: string) {
    return this.myApiService.getGraph(userId, skillid);
  }

  getSkillName(skill: string) {
    return this.myApiService.getSkillbyid(skill);
  }

  getalldata() {
    const fetchingPromises: Promise<any>[] = [];

    this.userskills.forEach(skill => {
      const fetchPromise = this.getGraph(this.user, skill).toPromise();

      fetchingPromises.push(fetchPromise);
    });

    Promise.all(fetchingPromises).then(graphDataArray => {
      const transformedSeries: any[] = [];

      this.userskills.forEach((skill, index) => {
        const graphData = graphDataArray[index];
        this.getSkillName(skill).subscribe(name => {
          // @ts-ignore
          const data = graphData.map(entry => entry[1]);
          transformedSeries.push({ name: name.name, data: data });

          if (transformedSeries.length === this.userskills.length) {
            this.transformedData = transformedSeries;
            this.updateChartSeries();
          }
        });
      });
    });
  }
  alignDataArrays(dataArrays: { name: string, data: number[] }[]): void {
    // Find the maximum length among all data arrays
    const maxLength = Math.max(...dataArrays.map(item => item.data.length));

    // Align data arrays by adding zeros at the beginning
    dataArrays.forEach(item => {
      const numberOfZerosToAdd = maxLength - item.data.length;
      // @ts-ignore
      item.data = Array.from({ length: numberOfZerosToAdd }).fill(0).concat(item.data);
    });
  }
   generateMonthCategories(): string[] {
    const categories: string[] = [];
    // @ts-ignore
     const currentDate = new Date(this.startDate);

    for (let i = 0; i < 2 * 12; i++) {
      const month = currentDate.toLocaleString('default', { month: 'short' });
      const year = currentDate.getFullYear() % 100;
      categories.push(`${month}-${year.toString().padStart(2, '0')}`);

      currentDate.setMonth(currentDate.getMonth() + 1);
    }

    return categories;
  }
  startDate = localStorage.getItem('join_date');
  updateChartSeries() {
    this.alignDataArrays(this.transformedData);
    this.chartOptions.series = this.transformedData;
    console.log(this.transformedData)
  }
}
