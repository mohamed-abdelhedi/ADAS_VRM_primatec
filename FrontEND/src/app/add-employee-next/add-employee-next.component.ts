import { Component } from '@angular/core';
import {faCamera} from "@fortawesome/free-solid-svg-icons";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-add-employee-next',
  templateUrl: './add-employee-next.component.html',
  styleUrls: ['./add-employee-next.component.css']
})
export class AddEmployeeNextComponent {

  protected readonly faCamera = faCamera;
  toppings = new FormControl('');
  toppingList: string[] = ['HTML', 'CSS', 'JavaScript', 'Angular', 'SpringBOOT', 'MySQL'];
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
}
