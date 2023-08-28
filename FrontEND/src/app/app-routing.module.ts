import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {EmployeePageComponent} from "./employee/employee-page/employee-page.component";
import {DASH} from "@angular/cdk/keycodes";
import {DashboardPageComponent} from "./dashboard/dashboard-page/dashboard-page.component";
import {TeamPageComponent} from "./team/team-page/team-page.component";
import {AddEmployeeDialogComponent} from "./employee/add-employee-dialog/add-employee-dialog.component";
import {AddEmployeeNextComponent} from "./Profile/add-employee-next/add-employee-next.component";
import {ProjectPageComponent} from "./project/project-page/project-page.component";
import {AssignUserJobComponent} from "./project/assign-user-job/assign-user-job.component";
import {ProfilePageComponent} from "./Profile/profile-page/profile-page.component";
import {AddTeamPageComponent} from "./team/add-team-page/add-team-page.component";
import {AddProjectPageComponent} from "./project/add-project-page/add-project-page.component";
import {DepartmentPageComponent} from "./department/department-page/department-page.component";
import {GroupPageComponent} from "./group/group-page/group-page.component";
import {AddDepartmentPageComponent} from "./department/add-department-page/add-department-page.component";
import {AddGroupPageComponent} from "./group/add-group-page/add-group-page.component";
import {LoginPageComponent} from "./login/login-page/login-page.component";
import {SettingsPageComponent} from "./settings-page/settings-page.component";
import {WorkloadPageComponent} from "./project/workload-page/workload-page.component";


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardPageComponent },
  { path: 'employee', component: EmployeePageComponent },
  { path: 'team', component: TeamPageComponent },
  { path: 'employee/add-employee', component: AddEmployeeDialogComponent },
  { path: 'employee/add-employee-next', component: AddEmployeeNextComponent },
  { path: 'project', component: ProjectPageComponent },
  { path: 'project/add_project', component: AddProjectPageComponent },
  { path: 'assign-user-project', component: AssignUserJobComponent },
  { path: 'profile', component: ProfilePageComponent },
  { path: 'team/add-team', component: AddTeamPageComponent },
  { path: 'department', component: DepartmentPageComponent },
  { path: 'group', component: GroupPageComponent },
  { path: 'department/add-department', component: AddDepartmentPageComponent },
  { path: 'group/add-group', component: AddGroupPageComponent },
  { path: 'settings', component: SettingsPageComponent },
  { path: 'project/workload', component: WorkloadPageComponent },
 // { path: 'login', component: LoginPageComponent },
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
