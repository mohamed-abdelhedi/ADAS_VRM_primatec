import { Component } from '@angular/core';
import {
  faAddressCard,
  faBookReader,
  faDashboard, faGear,
  faLaptop,
  faLock,
  faUser,
  faUsers
} from "@fortawesome/free-solid-svg-icons";

@Component({
    selector: 'dashboard-page',
  templateUrl: './dashboard-page.component.html',
  styleUrls: ['./dashboard-page.component.css']
})
export class DashboardPageComponent {


  activeNavItem: number = 1;
  onNavItemClicked(navItem: number) {
    this.activeNavItem = navItem;
  }

  protected readonly faDashboard = faDashboard;
  protected readonly faBookReader = faBookReader;
  protected readonly faUser = faUser;
  protected readonly faUsers = faUsers;
  protected readonly faLaptop = faLaptop;
  protected readonly faAddressCard = faAddressCard;
  protected readonly faGear = faGear;
}
