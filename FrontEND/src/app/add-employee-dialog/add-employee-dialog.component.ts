import {Component, Inject} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {faCamera} from "@fortawesome/free-solid-svg-icons";
import {Router} from "@angular/router";
import {MyApiService} from "../my-api.service";
@Component({
  selector: 'app-add-employee-dialog',
  templateUrl: './add-employee-dialog.component.html',
  styleUrls: ['./add-employee-dialog.component.css']
})
export class AddEmployeeDialogComponent {
  constructor(private router: Router,private myApiService: MyApiService) { }

  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee-next');
  }
  protected readonly faCamera = faCamera;

  employeeData = {
    name: '',
    birthdate: '',
    joinDate: '',
    username: '',
    email: '',
    imgLink: '',
    phone_number: ''
  };

  onSubmit() {
    // Call your service method to post data
    this.myApiService.addEmployee(this.employeeData).subscribe(response => {
      console.log(response);
    });
  }
}
