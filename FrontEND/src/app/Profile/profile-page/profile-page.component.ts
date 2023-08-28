import {Component} from '@angular/core';
import {MyApiService} from "../../services/APIs/my-api.service";
import jwt_decode from 'jwt-decode';
import {Router} from "@angular/router";

@Component({
  selector: 'profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent {
  userProfile: any;
  // @ts-ignore
  token: string = localStorage.getItem('access_token');
  headers = {"Authorization": "Bearer " + this.token};
  private userId: any;

  constructor(private myApiService: MyApiService, private router: Router) {
  }

  getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    } catch (Error) {
      return null;
    }
  }

  ngOnInit() {
    const tokenInfo = this.getDecodedAccessToken(this.token);
    this.userId = tokenInfo.user_id;
    this.addLastProficiency();
    localStorage.setItem('user_id', this.userId);


    this.myApiService.getUserProfile(this.userId).subscribe(
      (response) => {
        this.userProfile = response;
        console.log(response);
      },
    );

  }

  navigateToAddSkills() {
    console.log('Navigating to Add Employee');
    // Use the router to navigate to the "add-employee" page
    this.router.navigateByUrl('employee/add-employee-next');
  }


  isFirstDayOfMonth(date: Date): boolean {
    const currentDate = new Date();

    return currentDate.getFullYear() === date.getFullYear() &&
      currentDate.getMonth() === date.getMonth() &&
      currentDate.getDate() === 1;
  }

  addLastProficiency() {
    const today = new Date();
    if (this.isFirstDayOfMonth(today)) {
      this.myApiService.getalluserSKILLS(this.userId).subscribe(skillDataList => {
        console.log(skillDataList);

        for (const skillData of skillDataList) {
          this.myApiService.getUserSkillForPreviousMonth(skillData, this.userId).subscribe(userSkill => {
            console.log("userSkill", userSkill);


            const newUserSkill = {
              userId: this.userId,
              skillId: skillData,
              date: "2023-08-10", // Get current date in "YYYY-MM-DD" format
              // @ts-ignore
              proficiency: userSkill.proficiency
            };
            console.log("updatedUserSkill", newUserSkill);

            this.myApiService.adduserSkills(this.userId, [newUserSkill]).subscribe(result => {
              console.log(result);
            });
          });
        }
      });
    } else {
      console.log("NOOOOOO");
    }
}}
