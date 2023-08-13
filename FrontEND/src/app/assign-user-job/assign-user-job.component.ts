import { Component } from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";


@Component({

  selector: 'app-assign-user-job',
  templateUrl: './assign-user-job.component.html',
  styleUrls: ['./assign-user-job.component.css']
})

export class AssignUserJobComponent {

  users: string[] = ["user1","user2","user3"];


  employee = new FormControl([]);
  employeeList: string[] = ['HTML', 'CSS', 'JavaScript', 'Angular', 'SpringBOOT', 'MySQL'];
  selectedSkills: string[] = [];

  onToppingsSelectionChange(event: any) {
    this.selectedSkills = event.value;
    console.log(this.selectedSkills)
  }

  intValue: number = 0; // Initial value


  selectedOption: number = 0;
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
}
