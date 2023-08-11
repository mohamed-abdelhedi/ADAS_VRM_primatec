import { Component } from '@angular/core';

import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgbRatingConfig} from "@ng-bootstrap/ng-bootstrap";


@Component({
  selector: 'skills-dropdown',
  templateUrl: './skills-dropdown.component.html',
  styleUrls: ['./skills-dropdown.component.css'],
})
export class SkillsDropdownComponent {
  skills = new FormControl([]);
  skillsList: string[] = ['HTML', 'CSS', 'JavaScript', 'Angular', 'SpringBOOT', 'MySQL'];
  selectedSkills: string[] = [];

  onToppingsSelectionChange(event: any) {
    this.selectedSkills = event.value;
    console.log(this.selectedSkills)
  }
  starRating = 0;

  skill_rate: { [skill: string]: number } = {};

  constructor(config: NgbRatingConfig) {
    // Customize default values of ratings used by this component tree
    config.max = 5;
  }

}
