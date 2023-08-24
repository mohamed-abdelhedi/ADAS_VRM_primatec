import {Component, Inject} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {faCamera} from "@fortawesome/free-solid-svg-icons";
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";
import {AuthServicesService} from "../../services/authentication/auth-services.service";
@Component({
  selector: 'app-add-employee-dialog',
  templateUrl: './add-employee-dialog.component.html',
  styleUrls: ['./add-employee-dialog.component.css']
})
export class AddEmployeeDialogComponent {
  constructor(private router: Router,private myApiService: MyApiService,private AuthServicesService:AuthServicesService) { }

  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee-next');
  }
  protected readonly faCamera = faCamera;

  employeeData = {
    firstname: '',
    lastname: '',
    birthdate: '',
    joinDate: '',
    username: '',
    password:'',
    email: '',
    imgLink: '',
    phone_number: '',
    role:''
  };

  onSubmit() {
    this.employeeData.joinDate=new Date().toISOString().split('T')[0];
    this.employeeData.password=this.employeeData.email;
    this.employeeData.role='USER';
    console.log(this.employeeData);
    // Call your service method to post data
   /* this.myApiService.addEmployee(this.employeeData).subscribe(response => {
      console.log(response);
    });*/

    this.AuthServicesService.register(this.employeeData).subscribe(response => {
      console.log(response);
    });
  }
}
