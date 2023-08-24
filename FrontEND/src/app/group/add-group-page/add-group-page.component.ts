import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'app-add-group-page',
  templateUrl: './add-group-page.component.html',
  styleUrls: ['./add-group-page.component.css']
})
export class AddGroupPageComponent {
  text: string = ''; // Holds the textarea input
  selectedOption: number = 0;
  constructor(private router: Router,private myApiService: MyApiService) { }



  //api call
  userinfo:any;
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

  groupData = {
    name: '',
    domain: '',
    groupLead:'',
  };

  onSubmit() {
    // Call your service method to post data
    this.myApiService.addGroup(this.groupData).subscribe(response => {
      console.log(response);
    });
  }
}
