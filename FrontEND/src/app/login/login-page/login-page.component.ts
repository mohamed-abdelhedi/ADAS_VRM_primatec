import { Component } from '@angular/core';
import {faLock,faUser} from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import {AuthServicesService} from "../../services/authentication/auth-services.service";
@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
falock=faLock;
fauser=faUser;
  protected readonly faUser = faUser;
  constructor(private router: Router,private authService: AuthServicesService) { }


  loginData = {
    email: '',
    password: '',
  };


  onLoginClick() {
    this.authService.login(this.loginData).subscribe(
      (response) => {
        // Store the token in localStorage
        localStorage.setItem('access_token', response.access_token);

        console.log(response.access_token);
        this.router.navigate(['/dashboard']);
      },
      (error) => {
        console.error('Login error:', error);
      }
    );
  }
}
