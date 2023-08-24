import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'app-group-page',
  templateUrl: './group-page.component.html',
  styleUrls: ['./group-page.component.css']
})
export class GroupPageComponent {p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page


  constructor(private router: Router,private myApiService: MyApiService) { }

  navigateToAddGroup() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('group/add-group');
  }
  Groupinfo: any;
  ngOnInit(): void {
    this.fetchGroupInfo();

  }
  fetchGroupInfo(): void {
    this.myApiService.getGroupList().subscribe(
      (data) => {
        this.Groupinfo = data; // Store the retrieved user information
        console.log('Groupinfo', this.Groupinfo);
      },

    );
  }

}
