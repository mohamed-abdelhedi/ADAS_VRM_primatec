import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";
import {Observable, switchMap} from "rxjs";

@Component({
  selector: 'app-add-project-page',
  templateUrl: './add-project-page.component.html',
  styleUrls: ['./add-project-page.component.css']
})
export class AddProjectPageComponent {
  text: string = '';
  wordCount: number = 0;
  teamInfo: any;
  selectedOption: any;
  projectid:any;

  constructor(private router: Router, private myApiService: MyApiService) {
  }

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }

  JobData = {
    projectDescription: '',
    projectName: '',
    deadline: '',
    startDate: ''
  };

  ngOnInit(): void {
    this.fetchTeamInfo();

  }

  fetchTeamInfo(): void {
    this.myApiService.getTeamList().subscribe(
      (data) => {
        this.teamInfo = data;
        console.log('User Info:', this.teamInfo);
      },
    );
  }


  onSubmit() {
    this.myApiService.addJob(this.JobData).pipe(
      switchMap(response => {
        this.projectid = response.projectId;
        console.log('project id', this.projectid);
        return this.assignProjects();
      })
    ).subscribe(() => {
      console.log('assignProjects() completed');
    });
  }

  assignProjects(): Observable<any> {
    return this.myApiService.assignProjectToTeam(this.selectedOption, this.projectid);
  }


}
