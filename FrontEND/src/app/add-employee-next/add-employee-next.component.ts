import { Component } from '@angular/core';
import {faAdd, faCamera, faDeleteLeft, faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {MatSelectChange} from "@angular/material/select";

@Component({
  selector: 'app-add-employee-next',
  templateUrl: './add-employee-next.component.html',
  styleUrls: ['./add-employee-next.component.css']
})
export class AddEmployeeNextComponent {

  protected readonly faCamera = faCamera;

  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }


  diplomaForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.diplomaForm = this.fb.group({
      diplomaGroups: this.fb.array([this.createDiplomaGroup()])
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

  protected readonly faDeleteLeft = faDeleteLeft;
  protected readonly faTrash = faTrash;
  protected readonly faAdd = faAdd;
  protected readonly faPlus = faPlus;
}
