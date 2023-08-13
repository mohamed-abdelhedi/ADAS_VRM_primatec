import { Component } from '@angular/core';
import {Router} from "@angular/router";
interface Project {
  title: string;
  status: string;
  assignedTeam: string;
  startDate: Date;
}

@Component({
  selector: 'project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent {
  projects: Project[] = [
    {
      title: 'Project 1',
      status: 'In Progress',
      assignedTeam: 'Team A',
      startDate: new Date('2023-08-01')
    },
    {
      title: 'Project 2',
      status: 'Done',
      assignedTeam: 'Team B',
      startDate: new Date('2023-08-10')
    },
    {
      title: 'Project 3',
      status: 'Failed',
      assignedTeam: 'Team B',
      startDate: new Date('2023-08-10')
    },
    // Add more projects...
  ];

  getStatusClass(status: string): string {
    switch (status.toLowerCase()) {
      case 'in progress':
        return 'status-in-progress';
      case 'done':
        return 'status-done';
      case 'failed':
        return 'status-failed';
      default:
        return '';
    }
  }
  constructor(private router: Router) { }
  navigateToAddEmployee() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('assign-user-project');
  }
}
