import { Component } from '@angular/core';
import {faLock,faUser} from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'app-login-first-time',
  templateUrl: './login-first-time.component.html',
  styleUrls: ['./login-first-time.component.css']
})
export class LoginFirstTimeComponent {
  falock=faLock;
  fauser=faUser;
  protected readonly faUser = faUser;
}
