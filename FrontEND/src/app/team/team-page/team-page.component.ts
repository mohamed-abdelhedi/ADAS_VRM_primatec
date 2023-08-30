import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'team-page',
  templateUrl: './team-page.component.html',
  styleUrls: ['./team-page.component.css']
})
export class TeamPageComponent {
  teamInfo: any;
  projects: []=[]
  p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page


  getStatusClass(status: string) {
    return {
      'online-status': status === 'Online',
      'offline-status': status === 'Offline'
    };
  }



  constructor(private router: Router, private myApiService: MyApiService) {
  }

  navigateToAddTeam() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('team/add-team');
  }

  ngOnInit(): void {
    this.fetchTeamInfo();

  }

  fetchTeamInfo(): void {
    this.myApiService.getTeamList().subscribe(
      (data) => {
        this.teamInfo = data; // Store the retrieved user information
        console.log('User Info:', this.teamInfo);
        for (const team of this.teamInfo) {
          this.myApiService.sumProjectByTeam(team.team_id).subscribe(data => {
            // @ts-ignore
            this.projects.push(data);
            console.log(data)

          })
        }
      },
    );
  }

}
