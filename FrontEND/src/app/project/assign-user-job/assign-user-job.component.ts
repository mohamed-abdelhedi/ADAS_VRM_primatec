import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";
import {Observable, switchMap} from "rxjs";


@Component({

  selector: 'app-assign-user-job',
  templateUrl: './assign-user-job.component.html',
  styleUrls: ['./assign-user-job.component.css']
})

export class AssignUserJobComponent {
  selectedOption: number = 0;
  text: string = '';
  wordCount: number = 0;
  selectedSkills: string[] = [];
  SkillsInfo: any;
  projectid = localStorage.getItem('project_id');
  results: { [key: string]: string[] } = {};
  finalresults: { [key: string]: string[] } = {};
  userinfo2: any[] = [];
  workloadid: any;
  newSkills: any;
  newSkillsdata: any;
  userskill: string[] = []
  DomainInfo:any;

  onToppingsSelectionChange(event: any) {
    this.selectedSkills = event.value;
    this.results = this.userskillresult(this.results)
    console.log(this.results)
    this.finalresults = this.dataTransform(this.results)
    this.fetchselecteduserdetails();
  }

  Onsubmit2() {

  }

  constructor(private router: Router, private myApiService: MyApiService) {
  }

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }

  ngOnInit(): void {
    this.fetchSkillInfo();
    this.fetchDomainInfo();
  }

  fetchSkillInfo(): void {
    this.myApiService.getSkillList().subscribe(
      (data) => {
        this.SkillsInfo = data;
      },
    );
  }
  fetchDomainInfo(): void {
    this.myApiService.getDomainList().subscribe(
      (data) => {
        this.DomainInfo = data;
      },
    );
  }

  userskillresult(results: { [key: string]: string[] }) {

    for (const skill_id of this.selectedSkills) {
      this.myApiService.getUserSkills(skill_id).subscribe(
        response => {
          const responseArray = Object.values(response);
          // @ts-ignore
          results[skill_id] = responseArray;
        },
      );
    }
    return results
  }

  dataTransform(result: { [skill: string]: string[] }): { [user: string]: string[] } {
    const results2: { [user: string]: string[] } = {};
    for (const skill in result) {
      if (result.hasOwnProperty(skill)) {
        const users = result[skill];
        for (const user of users) {
          if (!results2.hasOwnProperty(user)) {
            results2[user] = [];
          }

          this.myApiService.getSkillbyid(skill).subscribe(
            (data) => {
              this.myApiService.getUserSkillProficiency(user, data.skill_id).subscribe((data2) => {
                if (!results2[user].includes(' ' + data.name + ' ' + data2 + ' '))
                  results2[user].push(' ' + data.name + ' ' + data2 + ' ');
              })


            }
          );
        }
      }
    }
    return results2;
  }


  fetchselecteduserdetails() {
    this.userinfo2 = [];
    for (const userId in Object.keys(this.finalresults)) {

      let index = Object.keys(this.finalresults)[userId]
      this.myApiService.getUserProfile(index).subscribe(
        response => {
          this.userinfo2.push(response)
        },
      );
    }
  }

  WorkloadData = {
    workloadId: '',
    name: '',
    startDate: '',
    description: '',
    percentage: '',
    workloadState: 'TO_DO',
    deadLine: '',
    domain:'',
  };

  assignProjects(): Observable<any> {
    console.log('user', this.selectedOption);
    const requestBody = {"projectIds": [this.projectid], "userIds": [this.selectedOption]};
    const skillsbody = {"skillIds": this.selectedSkills};

    // Make API calls and return Observables
    return this.myApiService.assignWorkloadtoProject(this.workloadid, requestBody).pipe(
      switchMap(() => {
        return this.myApiService.assignWorkloadSkills(this.workloadid, skillsbody);
      })
    );
  }


  onSubmit() {
    this.myApiService.addWorkload(this.WorkloadData).pipe(
      switchMap(response => {
        this.workloadid = response.workloadId;
        return this.assignProjects();
      })
    ).subscribe(() => {

    });
    this.myApiService.getalluserSKILLS(this.selectedOption.toString()).subscribe(data => {
      this.userskill = data;
      console.log('this.selectedSkills',this.selectedSkills)
      console.log('userskill',this.userskill)
      this.newSkills = this.selectedSkills.filter(element => !this.userskill.includes(element));
      console.log('this.newSkills',this.newSkills)

      // @ts-ignore
      this.newSkillsdata = this.newSkills.map(skill => {
        return {
          skillId: skill,
          proficiency: 1
        };
      });
      console.log(this.newSkillsdata)
      this.myApiService.adduserSkills(this.selectedOption.toString(), this.newSkillsdata).subscribe(response => {

      });
    })
  }


   filterSkills(userskill: any[], skillData: any[]): any[] {
    const newSkills = [];
    for (const userSkill of userskill) {
      let found = false;
      for (const skillDataItem of skillData) {
        if (userSkill.skillId === skillDataItem.skillId) {
          found = true;
          break;
        }
      }
      if (!found) {
        newSkills.push(userSkill);
      }
    }
    return newSkills;
  }
}
