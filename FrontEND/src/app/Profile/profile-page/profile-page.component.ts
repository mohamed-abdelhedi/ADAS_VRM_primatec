import { Component } from '@angular/core';
import {MyApiService} from "../../services/APIs/my-api.service";
import jwt_decode from 'jwt-decode';
import {AuthServicesService} from "../../services/authentication/auth-services.service";
@Component({
  selector: 'profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent {
  userProfile: any;
  // @ts-ignore
  token:string = localStorage.getItem('access_token');
  headers = {"Authorization": "Bearer " + this.token};
  constructor(private myApiService: MyApiService, private AuthServicesService:AuthServicesService) { }

  getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }
  ngOnInit() {
    const tokenInfo = this.getDecodedAccessToken(this.token);
    console.log("token-info",tokenInfo);

    const userId = tokenInfo.user_id;

    this.myApiService.getUserProfile(userId).subscribe(
      (response) => {
        this.userProfile = response;
        console.log(response);
      },

    );
    console.log(this.userProfile);
  }


}
