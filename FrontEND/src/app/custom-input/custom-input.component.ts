import {Component, Input} from '@angular/core';
import {faLock} from '@fortawesome/free-solid-svg-icons';
@Component({
  selector: 'custom-input',
  templateUrl: './custom-input.component.html',
  styleUrls: ['./custom-input.component.css']
})
export class CustomInputComponent {
falock=faLock;
@Input() icon:any;
@Input() placeholder!: string;
}
