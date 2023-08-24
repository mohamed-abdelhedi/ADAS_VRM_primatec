import {Component, OnInit,} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'employee-page',
  templateUrl: './employee-page.component.html',
  styleUrls: ['./employee-page.component.css']
})
export class EmployeePageComponent implements OnInit{

  p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page


  getStatusClass(status: string) {
    return {
      'online-status': status === 'Online',
      'offline-status': status === 'Offline'
    };
  }

  constructor(private router: Router,private myApiService: MyApiService) { }

  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee');
  }
  userInfo: any;
  testinfo:any
  ngOnInit(): void {
    this.fetchUserInfo();

  }
  fetchUserInfo(): void {
    this.myApiService.getEmployeesList().subscribe(
      (data) => {
        this.userInfo = data; // Store the retrieved user information
        console.log('User Info:', this.userInfo);
      },
    );
  }

  getAge(birthdate: string): number {
    const today = new Date();
    const birthDate = new Date(birthdate);
    let age = today.getFullYear() - birthDate.getFullYear();

    const monthDiff = today.getMonth() - birthDate.getMonth();
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }

    return age;
  }
}
