import {Component, Input} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'project-page',
  templateUrl: './project-page.component.html',
  styleUrls: ['./project-page.component.css']
})
export class ProjectPageComponent {
  jobinfo: any;

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

  constructor(private router: Router, private myApiService: MyApiService) {
  }

  navigateToAddEmployee(id:string) {
    localStorage.setItem('project_id',id)
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('assign-user-project');
  }
  navigateToWorkload(id:string) {
    localStorage.setItem('project_id',id)
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('project/workload');
  }

  navigateToAddProject() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('project/add_project');
  }


  ngOnInit(): void {
    this.fetchJobInfo();
  }

  fetchJobInfo(): void {
    this.myApiService.getJobList().subscribe(
      (data) => {
        this.jobinfo = data;
        console.log('Job Info:', this.jobinfo);
      },
    );
  }

}
