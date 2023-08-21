import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CustomInputComponent } from './custom-input/custom-input.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SideBarComponent } from './side-bar/side-bar.component';
import { JobStatisticComponent } from './job-statistic/job-statistic.component';
import {NgApexchartsModule} from "ng-apexcharts";
import { EmployeePageComponent } from './employee-page/employee-page.component';

import { CommonModule } from '@angular/common';
import {NgxPaginationModule} from "ngx-pagination";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {MatButtonModule} from "@angular/material/button";
import { AddEmployeeDialogComponent } from './add-employee-dialog/add-employee-dialog.component';
import { LoginFirstTimeComponent } from './login-first-time/login-first-time.component';

import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatDialogModule} from "@angular/material/dialog";
import { TeamPageComponent } from './team-page/team-page.component';
import {AppRoutingModule} from "./app-routing.module";
import {RouterOutlet} from "@angular/router";
import { AddEmployeeNextComponent } from './add-employee-next/add-employee-next.component';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import { SkillsDropdownComponent } from './skills-dropdown/skills-dropdown.component';
import {IgcFormsModule} from "igniteui-angular";
import {StarRatingModule} from "angular-star-rating";
import { ProjectPageComponent } from './project-page/project-page.component';
import { AssignUserJobComponent } from './assign-user-job/assign-user-job.component';
import {HttpClientModule} from "@angular/common/http";
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { AddTeamPageComponent } from './add-team-page/add-team-page.component';
import { AddProjectPageComponent } from './add-project-page/add-project-page.component';
import { ApxColumnComponent } from './apx-column/apx-column.component';
import { ApxLineComponent } from './apx-line/apx-line.component';




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
    SkillsDropdownComponent,
    ProjectPageComponent,
    AssignUserJobComponent,
    ProfilePageComponent,
    AddTeamPageComponent,
    AddProjectPageComponent,
    ApxColumnComponent,
    ApxLineComponent,

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
