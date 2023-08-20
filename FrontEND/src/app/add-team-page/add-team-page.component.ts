import { Component } from '@angular/core';

@Component({
  selector: 'add-team-page',
  templateUrl: './add-team-page.component.html',
  styleUrls: ['./add-team-page.component.css']
})
export class AddTeamPageComponent {
  text: string = ''; // Holds the textarea input
  wordCount: number = 0; // Holds the word count

  countWords() {
    const words = this.text.split(/\s+/).filter(Boolean);
    this.wordCount = words.length;
  }
  selectedOption: number = 0;
  users: string[] = ["user1","user2","user3"];
}
