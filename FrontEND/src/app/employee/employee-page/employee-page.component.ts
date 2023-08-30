import {Component, OnInit,} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'employee-page',
  templateUrl: './employee-page.component.html',
  styleUrls: ['./employee-page.component.css']
})
export class EmployeePageComponent implements OnInit {

  p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page
  userInfo: any;
  testinfo: any
  percentageInfo:[]=[]

  getStatusClass(status: string) {
    return {
      'online-status': status === 'Online',
      'offline-status': status === 'Offline'
    };
  }

  constructor(private router: Router, private myApiService: MyApiService) {
  }

  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee');
  }

  ngOnInit(): void {
    this.fetchUserInfo();
  }

  fetchUserInfo(): void {
    this.myApiService.getEmployeesList().subscribe(
      (data) => {
        this.userInfo = data;
        for (const user of this.userInfo) {
          this.myApiService.getPercentage(user.user_id).subscribe(data => {
            console.log('data', data);
            const percentageValue = data ? data : 0; // If data is null, use 0
            // @ts-ignore
            this.percentageInfo.push(percentageValue);
          });
        }
        console.log(this.percentageInfo)
        // Store the retrieved user information
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
