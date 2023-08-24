import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginPageComponent } from './login/login-page/login-page.component';
import { CustomInputComponent } from './custom-input/custom-input.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { DashboardPageComponent } from './dashboard/dashboard-page/dashboard-page.component';
import { NavBarComponent } from './mainpage/nav-bar/nav-bar.component';
import { SideBarComponent } from './mainpage/side-bar/side-bar.component';
import { JobStatisticComponent } from './dashboard/job-statistic/job-statistic.component';
import {NgApexchartsModule} from "ng-apexcharts";
import { EmployeePageComponent } from './employee/employee-page/employee-page.component';
import { CommonModule } from '@angular/common';
import {NgxPaginationModule} from "ngx-pagination";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import { AddEmployeeDialogComponent } from './employee/add-employee-dialog/add-employee-dialog.component';
import { LoginFirstTimeComponent } from './login/login-first-time/login-first-time.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatDialogModule} from "@angular/material/dialog";
import { TeamPageComponent } from './team/team-page/team-page.component';
import {AppRoutingModule} from "./app-routing.module";
import {RouterOutlet} from "@angular/router";
import { AddEmployeeNextComponent } from './employee/add-employee-next/add-employee-next.component';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {IgcFormsModule} from "igniteui-angular";
import {StarRatingModule} from "angular-star-rating";
import { ProjectPageComponent } from './project/project-page/project-page.component';
import { AssignUserJobComponent } from './project/assign-user-job/assign-user-job.component';
import {HttpClientModule} from "@angular/common/http";
import { ProfilePageComponent } from './Profile/profile-page/profile-page.component';
import { AddTeamPageComponent } from './team/add-team-page/add-team-page.component';
import { AddProjectPageComponent } from './project/add-project-page/add-project-page.component';
import { ApxColumnComponent } from './Profile/apx-column/apx-column.component';
import { ApxLineComponent } from './Profile/apx-line/apx-line.component';
import { DepartmentPageComponent } from './department/department-page/department-page.component';
import { AddDepartmentPageComponent } from './department/add-department-page/add-department-page.component';
import { GroupPageComponent } from './group/group-page/group-page.component';
import { AddGroupPageComponent } from './group/add-group-page/add-group-page.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    CustomInputComponent,
    DashboardPageComponent,
    NavBarComponent,
    SideBarComponent,
    JobStatisticComponent,
    EmployeePageComponent,
    AddEmployeeDialogComponent,
    LoginFirstTimeComponent,
    TeamPageComponent,
    AddEmployeeNextComponent,
    ProjectPageComponent,
    AssignUserJobComponent,
    ProfilePageComponent,
    AddTeamPageComponent,
    AddProjectPageComponent,
    ApxColumnComponent,
    ApxLineComponent,
    DepartmentPageComponent,
    AddDepartmentPageComponent,
    GroupPageComponent,
    AddGroupPageComponent,

  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [
    BrowserModule,
    NgbModule,
    FontAwesomeModule,
    NgApexchartsModule,
    CommonModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    AppRoutingModule,
    FormsModule,
    RouterOutlet,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    IgcFormsModule,
    StarRatingModule.forRoot(),
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}
