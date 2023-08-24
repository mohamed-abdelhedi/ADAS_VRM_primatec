import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'app-add-department-page',
  templateUrl: './add-department-page.component.html',
  styleUrls: ['./add-department-page.component.css']
})
export class AddDepartmentPageComponent {
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
  selectedOption: number = 0;
  selectedOption2: number = 0;
  users: string[] = ["user1","user2","user3"];

  constructor(private router: Router,private myApiService: MyApiService) { }



  //api call
  userinfo:any;
  groupinfo:any;
  departmentinfo:any;
  ngOnInit(): void {
    this.getDepartmentList();
    this.getEmployeesList();

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

  departmentData = {
    name: '',
    location: '',
    departmentLead:'',
    parentDepartment:'',
  };
  onSelectChange() {
    console.log(this.selectedOption)
  }

  onSubmit() {
    console.log(this.departmentData)
    // Call your service method to post data
    this.myApiService.addDepartment(this.departmentData).subscribe(response => {
      console.log(response);
    });
  }
}
