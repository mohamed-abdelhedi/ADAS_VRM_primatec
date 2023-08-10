import { Component } from '@angular/core';
import {faLock,faUser} from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
falock=faLock;
fauser=faUser;
  protected readonly faUser = faUser;
  constructor(private router: Router) { }

  onButtonClick() {
    // Navigate to component Y
    this.router.navigate(['/new-password']);
  }
}
