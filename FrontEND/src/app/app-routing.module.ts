import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {EmployeePageComponent} from "./employee-page/employee-page.component";
import {DASH} from "@angular/cdk/keycodes";
import {DashboardPageComponent} from "./dashboard-page/dashboard-page.component";
import {TeamPageComponent} from "./team-page/team-page.component";
import {AddEmployeeDialogComponent} from "./add-employee-dialog/add-employee-dialog.component";
import {AddEmployeeNextComponent} from "./add-employee-next/add-employee-next.component";


const routes: Routes = [

  { path: 'dashboard', component: DashboardPageComponent },
  { path: 'employee', component: EmployeePageComponent },
  { path: 'team', component: TeamPageComponent },
  { path: 'employee/add-employee', component: AddEmployeeDialogComponent },
  { path: 'employee/add-employee-next', component: AddEmployeeNextComponent },
];
@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes),CommonModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
