import { Component } from '@angular/core';

@Component({
  selector: 'app-settings-page',
  templateUrl: './settings-page.component.html',
  styleUrls: ['./settings-page.component.css']
})
export class SettingsPageComponent {

  signout() {
    localStorage.setItem('authenticated',"false")
    location.reload();
  }
}
