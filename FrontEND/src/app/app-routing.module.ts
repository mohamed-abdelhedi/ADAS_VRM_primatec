import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {EmployeePageComponent} from "./employee-page/employee-page.component";
import {DASH} from "@angular/cdk/keycodes";
import {DashboardPageComponent} from "./dashboard-page/dashboard-page.component";
import {TeamPageComponent} from "./team-page/team-page.component";
import {AddEmployeeDialogComponent} from "./add-employee-dialog/add-employee-dialog.component";
import {AddEmployeeNextComponent} from "./add-employee-next/add-employee-next.component";
import {ProjectPageComponent} from "./project-page/project-page.component";
import {AssignUserJobComponent} from "./assign-user-job/assign-user-job.component";
import {ProfilePageComponent} from "./profile-page/profile-page.component";
import {AddTeamPageComponent} from "./add-team-page/add-team-page.component";
import {AddProjectPageComponent} from "./add-project-page/add-project-page.component";


const routes: Routes = [

  { path: 'dashboard', component: DashboardPageComponent },
  { path: 'employee', component: EmployeePageComponent },
  { path: 'team', component: TeamPageComponent },
  { path: 'employee/add-employee', component: AddEmployeeDialogComponent },
  { path: 'employee/add-employee-next', component: AddEmployeeNextComponent },
  { path: 'project', component: ProjectPageComponent },
  { path: 'assign-user-project', component: AssignUserJobComponent },
  { path: 'profile', component: ProfilePageComponent },
  { path: 'team/add-team', component: AddTeamPageComponent },
  { path: 'project/add-project', component: AddProjectPageComponent },
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
