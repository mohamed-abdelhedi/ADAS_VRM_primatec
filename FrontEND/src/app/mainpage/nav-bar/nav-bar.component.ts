import { Component } from '@angular/core';
import {faBell, faSearch} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  protected readonly faSearch = faSearch;
  protected readonly faBell = faBell;
}
