import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";


@Component({
  selector: 'dashboard-page',
  templateUrl: './dashboard-page.component.html',
  styleUrls: ['./dashboard-page.component.css']
})
export class DashboardPageComponent {

  users: any
  projects: any
  workloads: any
  activeNavItem: number = 1;

  onNavItemClicked(navItem: number) {
    this.activeNavItem = navItem;
  }

  constructor(private router: Router, private myApiService: MyApiService) {
  }

  sumemployee() {
    this.myApiService.sumUser().subscribe(data => {
      this.users = data
    })
  }
  sumproject() {
    this.myApiService.sumProject().subscribe(data => {
      this.projects = data
    })
  }
  sumworkload() {
    this.myApiService.sumworkload().subscribe(data => {
      this.workloads = data
    })
  }
  ngOnInit(): void {
    this.sumemployee();
    this.sumproject();
    this.sumworkload();
  }
}
