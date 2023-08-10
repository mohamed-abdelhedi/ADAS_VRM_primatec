import {Component, ViewContainerRef} from '@angular/core';
import {AddEmployeeDialogComponent} from "../add-employee-dialog/add-employee-dialog.component";
import {Dialog, DialogRef, DIALOG_DATA, DialogModule} from '@angular/cdk/dialog';
import {MatDialog} from "@angular/material/dialog";

import {Router} from "@angular/router";
interface Employee {
  name: string;
  department: string;
  group: string;
  totalProjects: number;
  totalTasks: number;
  age: number;
  status: "Online" | "Offline";
}
@Component({
  selector: 'employee-page',
  templateUrl: './employee-page.component.html',
  styleUrls: ['./employee-page.component.css']
})
export class EmployeePageComponent {
  employees: Employee[] = [
    {
      name: "John Doe",
      department: "HR",
      group: "Team A",
      totalProjects: 5,
      totalTasks: 25,
      age: 30,
      status: "Online"
    },
    {
      name: "Jane Smith",
      department: "IT",
      group: "Development",
      totalProjects: 8,
      totalTasks: 40,
      age: 28,
      status: "Offline"
    },
    {
      name: 'Jane Smith',
      department: 'HR',
      group: 'Team A',
      totalProjects: 5,
      totalTasks: 50,
      age: 30,
      status: 'Online'
    },
    {
      name: 'John Doe',
      department: 'Finance',
      group: 'Team B',
      totalProjects: 8,
      totalTasks: 70,
      age: 35,
      status: 'Offline'
    },
    {
      name: "John Doe",
      department: "HR",
      group: "Team A",
      totalProjects: 5,
      totalTasks: 25,
      age: 30,
      status: "Online"
    },
    {
      name: "Jane Smith",
      department: "IT",
      group: "Development",
      totalProjects: 8,
      totalTasks: 40,
      age: 28,
      status: "Offline"
    },
    {
      name: 'Jane Smith',
      department: 'HR',
      group: 'Team A',
      totalProjects: 5,
      totalTasks: 50,
      age: 30,
      status: 'Online'
    },
    {
      name: 'John Doe',
      department: 'Finance',
      group: 'Team B',
      totalProjects: 8,
      totalTasks: 70,
      age: 35,
      status: 'Offline'
    },
    {
      name: "John Doe",
      department: "HR",
      group: "Team A",
      totalProjects: 5,
      totalTasks: 25,
      age: 30,
      status: "Online"
    },
    {
      name: "Jane Smith",
      department: "IT",
      group: "Development",
      totalProjects: 8,
      totalTasks: 40,
      age: 28,
      status: "Offline"
    },
    {
      name: 'Jane Smith',
      department: 'HR',
      group: 'Team A',
      totalProjects: 5,
      totalTasks: 50,
      age: 30,
      status: 'Online'
    },
    {
      name: 'John Doe',
      department: 'Finance',
      group: 'Team B',
      totalProjects: 8,
      totalTasks: 70,
      age: 35,
      status: 'Offline'
    }

    // Add more employee objects as needed...
  ];
  p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page
  addEmployee() {
    // You can implement the logic to add a new employee here.
  }

  getStatusClass(status: string) {
    return {
      'online-status': status === 'Online',
      'offline-status': status === 'Offline'
    };
  }


  //constructor(private dialog: MatDialog) {}

 // openAddEmployeeDialog(): void {
  //  const dialogRef = this.dialog.open(AddEmployeeDialogComponent, {
   //   width: '800px',
   //   height:'600px',
   //   panelClass: 'custom-dialog'
  //  });

 //   dialogRef.afterClosed().subscribe(result => {
     // Handle dialog close if needed
  //  });


  //}
  constructor(private router: Router) { }

  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee');
  }
  ngOnInit(): void {
    console.log('Navigating to Add Employee');
  }
}
