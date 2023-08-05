import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { CustomInputComponent } from './custom-input/custom-input.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from "@fortawesome/angular-fontawesome";
import { DashboardPageComponent } from './dashboard-page/dashboard-page.component';




@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    CustomInputComponent,
    DashboardPageComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    FontAwesomeModule,


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {

}
