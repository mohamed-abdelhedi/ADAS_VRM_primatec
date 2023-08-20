import {Component, OnInit,} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../my-api.service";
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
export class EmployeePageComponent implements OnInit{
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


  ];
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
  ngOnInit(): void {
    this.myApiService.getSomeData().subscribe(response => {
      console.log(response);
    });
  }
}
