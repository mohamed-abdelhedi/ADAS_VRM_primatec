import {Component, EventEmitter, Output} from '@angular/core';
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
  selector: 'side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {

  @Output() navItemClicked = new EventEmitter<number>();
  activeNavItem: number = 1; // Initialize activeNavItem with a default value (e.g., 1 for Dashboard)

  onNavItemClicked(navItem: number) {
    this.activeNavItem = navItem; // Update the activeNavItem when a navigation item is clicked
    this.navItemClicked.emit(navItem);
  }

  protected readonly faDashboard = faDashboard;
  protected readonly faBookReader = faBookReader;
  protected readonly faUser = faUser;
  protected readonly faUsers = faUsers;
  protected readonly faLaptop = faLaptop;
  protected readonly faAddressCard = faAddressCard;
  protected readonly faGear = faGear;
}
