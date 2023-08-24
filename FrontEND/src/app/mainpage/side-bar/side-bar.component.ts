import {Component, EventEmitter, Output} from '@angular/core';
import {
  faAddressCard,
  faBookReader, faBuilding,
  faDashboard, faGear,
  faLaptop,
  faLock, faPeopleGroup,
  faUser,
  faUsers
} from "@fortawesome/free-solid-svg-icons";
import {Router} from "@angular/router";
@Component({
  selector: 'side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent {

  @Output() navItemClicked = new EventEmitter<number>();
  activeNavItem: number = 1; // Initialize activeNavItem with a default value (e.g., 1 for Dashboard)



  protected readonly faDashboard = faDashboard;
  protected readonly faUser = faUser;
  protected readonly faUsers = faUsers;
  protected readonly faLaptop = faLaptop;
  protected readonly faAddressCard = faAddressCard;
  protected readonly faGear = faGear;
  protected readonly faBuilding = faBuilding;
  protected readonly faPeopleGroup = faPeopleGroup;

  constructor(private router: Router) {}

  onNavItemClicked(navItem: number) {
    if (navItem === 1) {
      this.router.navigate(['/dashboard']);
      this.activeNavItem=1;
    } else if (navItem === 2) {
      this.router.navigate(['/employee']);
      this.activeNavItem=2;
    } else if (navItem === 3) {
      this.router.navigate(['/team']);
      this.activeNavItem=3;
    }else if (navItem === 4) {
      this.router.navigate(['/department']);
      this.activeNavItem=4;
    }else if (navItem === 5) {
      this.router.navigate(['/group']);
      this.activeNavItem=5;
    }
    else if (navItem === 6) {
      this.router.navigate(['/project']);
      this.activeNavItem=6;
    }
    else if (navItem === 7) {
      this.router.navigate(['/profile']);
      this.activeNavItem=7;
    }
    else if (navItem === 8) {
      this.router.navigate(['/settings']);
      this.activeNavItem=8;
    }
    // ... handle other navigation items
  }






}
