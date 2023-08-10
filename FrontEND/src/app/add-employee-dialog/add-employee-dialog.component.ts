import {Component, Inject} from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {faCamera} from "@fortawesome/free-solid-svg-icons";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-employee-dialog',
  templateUrl: './add-employee-dialog.component.html',
  styleUrls: ['./add-employee-dialog.component.css']
})
export class AddEmployeeDialogComponent {
  constructor(private router: Router) { }
  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee-next');
  }
  protected readonly faCamera = faCamera;
}
