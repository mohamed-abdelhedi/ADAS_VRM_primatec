import {Component} from '@angular/core';
import {faAdd, faCamera, faDeleteLeft, faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {NgbRatingConfig} from "@ng-bootstrap/ng-bootstrap";
import {MyApiService} from "../../services/APIs/my-api.service";
import jwt_decode from "jwt-decode";

interface Skill {
  name: string;
  skill_id: string;
  proficiency: number;
}

@Component({
  selector: 'app-add-employee-next',
  templateUrl: './add-employee-next.component.html',
  styleUrls: ['./add-employee-next.component.css']
})
export class AddEmployeeNextComponent {
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count
  selectedSkills: Skill[] = [];
  skillinfo: any;
  SkillData: {} = {};
  userId:string=''
  // @ts-ignore
  token:string = localStorage.getItem('access_token');
  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }

  constructor(config: NgbRatingConfig, private myApiService: MyApiService) {
    config.max = 5;
  }

  getDecodedAccessToken(token: string): any {
    try {
      return jwt_decode(token);
    } catch(Error) {
      return null;
    }
  }
  ngOnInit(): void {
    this.getskillsList();
    const tokenInfo = this.getDecodedAccessToken(this.token);
     this.userId = tokenInfo.user_id;
  }

  onToppingsSelectionChange(event: any) {
    this.selectedSkills = event.value;
    console.log('selectedSkills', this.selectedSkills)

  }

  getskillsList(): void {
    this.myApiService.getSkillList().subscribe(
      (data) => {
        this.skillinfo = data;
        console.log('skillinfo:', this.skillinfo);
      },
    );
  }

  onSubmit() {
    console.log(this.selectedSkills)
    this.SkillData = this.selectedSkills.map(skill => {
      return {
        skillId: skill.skill_id,
        proficiency: skill.proficiency
      };
    });
    console.log('test', this.SkillData);
    this.myApiService.adduserSkills(this.userId,this.SkillData).subscribe(response => {
      console.log(response);
    });
  }

}
