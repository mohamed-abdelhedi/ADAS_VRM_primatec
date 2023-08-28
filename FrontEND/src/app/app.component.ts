import { Component } from '@angular/core';
import {AuthServicesService} from "./services/authentication/auth-services.service";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
  activeNavItem: number = 3;

  onNavItemClicked(navItem: number) {
    this.activeNavItem = navItem;}


  isAuthenticated: boolean = false;

  constructor(private authService: AuthServicesService) {
    // Check authentication status and set the flag

    this.isAuthenticated = localStorage.getItem('authenticated')=='true';
  }
}
