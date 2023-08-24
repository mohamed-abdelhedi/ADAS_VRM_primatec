import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'app-add-project-page',
  templateUrl: './add-project-page.component.html',
  styleUrls: ['./add-project-page.component.css']
})
export class AddProjectPageComponent {
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count
  constructor(private router: Router,private myApiService: MyApiService) { }
  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
  selectedOption: number = 0;
  users: string[] = ["user1","user2","user3"];

  JobData = {
    projectDescription: '',
    projectName: '',
    deadline:'',
    startDate:'',


  };


  teamInfo:any;
  ngOnInit(): void {
    this.fetchTeamInfo();

  }
  fetchTeamInfo(): void {
    this.myApiService.getTeamList().subscribe(
      (data) => {
        this.teamInfo = data; // Store the retrieved user information
        console.log('User Info:', this.teamInfo);
      },

    );
  }
  onSubmit() {
    // Call your service method to post data
    this.myApiService.addJob(this.JobData).subscribe(response => {
      console.log(response);
    });
  }





}
