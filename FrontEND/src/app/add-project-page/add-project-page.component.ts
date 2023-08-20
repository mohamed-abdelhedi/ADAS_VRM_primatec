import { Component } from '@angular/core';

@Component({
  selector: 'app-add-project-page',
  templateUrl: './add-project-page.component.html',
  styleUrls: ['./add-project-page.component.css']
})
export class AddProjectPageComponent {
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
  selectedOption: number = 0;
  users: string[] = ["user1","user2","user3"];
}
