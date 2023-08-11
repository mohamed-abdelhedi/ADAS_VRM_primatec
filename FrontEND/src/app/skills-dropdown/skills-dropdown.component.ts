import { Component } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {MatSelectChange} from "@angular/material/select";

@Component({
  selector: 'skills-dropdown',
  templateUrl: './skills-dropdown.component.html',
  styleUrls: ['./skills-dropdown.component.css']
})
export class SkillsDropdownComponent {
  toppings = new FormControl([]);
  toppingList: string[] = ['HTML', 'CSS', 'JavaScript', 'Angular', 'SpringBOOT', 'MySQL'];
  selectedToppings: string[] = [];

  onToppingsSelectionChange(event: any) {
    this.selectedToppings = event.value;
    console.log("test")
  }
}
