import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'add-team-page',
  templateUrl: './add-team-page.component.html',
  styleUrls: ['./add-team-page.component.css']
})
export class AddTeamPageComponent {
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
  selectedOption: number = 0;
  users: string[] = ["user1","user2","user3"];

  constructor(private router: Router,private myApiService: MyApiService) { }



  //api call
  userinfo:any;
  groupinfo:any;
  departmentinfo:any;
  ngOnInit(): void {
    this.getDepartmentList();
    this.getEmployeesList();
    this.getGroupList();
  }
  getDepartmentList(): void {
    this.myApiService.getDepartmentList().subscribe(
      (data) => {
        this.departmentinfo = data; // Store the retrieved user information
        console.log('departmentinfo:', this.departmentinfo);
      },
    );
  }
  getEmployeesList(): void {
    this.myApiService.getEmployeesList().subscribe(
      (data) => {
        this.userinfo = data; // Store the retrieved user information
        console.log('User Info:', this.userinfo);
      },
    );
  }
  getGroupList(): void {
    this.myApiService.getGroupList().subscribe(
      (data) => {
        this.groupinfo = data; // Store the retrieved user information
        console.log('groupinfo', this.groupinfo);
      },
    );
  }

  teamData = {
    name: '',
    description: '',
    teamLead:'',
  };

  onSubmit() {
    console.log(this.teamData)
    // Call your service method to post data
    this.myApiService.addTeam(this.teamData).subscribe(response => {
      console.log(response);
    });
  }
}
