import { Component } from '@angular/core';
import {faAdd, faCamera, faDeleteLeft, faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {NgbRatingConfig} from "@ng-bootstrap/ng-bootstrap";
import {MyApiService} from "../../services/APIs/my-api.service";

interface Skill {
  name: string;
  id: string;
  proficiency:number;
}
@Component({
  selector: 'app-add-employee-next',
  templateUrl: './add-employee-next.component.html',
  styleUrls: ['./add-employee-next.component.css']
})
export class AddEmployeeNextComponent {
  protected readonly faCamera = faCamera;
  protected readonly faDeleteLeft = faDeleteLeft;
  protected readonly faTrash = faTrash;
  protected readonly faAdd = faAdd;
  protected readonly faPlus = faPlus;
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count
  diplomaForm: FormGroup;
  selectedSkills: Skill[]=[]
  skillinfo:any;
  SkillData: {} = {};
  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }

  constructor(private fb: FormBuilder,config: NgbRatingConfig, private myApiService: MyApiService) {
    this.diplomaForm = this.fb.group({
      diplomaGroups: this.fb.array([this.createDiplomaGroup()])
    });
    config.max = 5;
  }
 ngOnInit(): void {
    this.getskillsList();
  }

  onToppingsSelectionChange(event: any) {
    this.selectedSkills = event.value;
    console.log('selectedSkills',this.selectedSkills)

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
    this.SkillData = this.selectedSkills.map(skill => {
      return {
        skillId: skill.id,
        proficiency: skill.proficiency
      };
    });
    console.log('test',this.SkillData);
    this.myApiService.adduserSkills(this.SkillData).subscribe(response => {
      console.log(response);
    });
  }

  get diplomaGroups() {
    return this.diplomaForm.get('diplomaGroups') as FormArray;
  }
  createDiplomaGroup() {
    return this.fb.group({
      diploma: '',
      birthdate: ''
    });
  }
  addDiplomaGroup() {
    this.diplomaGroups.push(this.createDiplomaGroup());
  }
  deleteDiplomaGroup(index: number) {
    this.diplomaGroups.removeAt(index);
  }
}
