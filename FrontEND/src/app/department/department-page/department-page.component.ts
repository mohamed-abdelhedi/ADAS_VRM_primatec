import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'app-department-page',
  templateUrl: './department-page.component.html',
  styleUrls: ['./department-page.component.css']
})
export class DepartmentPageComponent implements OnInit {
  p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page


  constructor(private router: Router,private myApiService: MyApiService) { }

  navigateToAddDepartment() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('department/add-department');
  }
  DepartmentInfo: any;
  ngOnInit(): void {
    this.fetchdepartmentInfo();

  }
  fetchdepartmentInfo(): void {
    this.myApiService.getDepartmentList().subscribe(
      (data) => {
        this.DepartmentInfo = data; // Store the retrieved user information
        console.log('DepartmentInfo', this.DepartmentInfo);
      },

    );
  }
}
