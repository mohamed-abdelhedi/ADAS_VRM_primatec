import { Component } from '@angular/core';


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
}
