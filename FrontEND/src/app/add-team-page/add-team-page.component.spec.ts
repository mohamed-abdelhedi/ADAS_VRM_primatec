import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTeamPageComponent } from './add-team-page.component';

describe('AddTeamPageComponent', () => {
  let component: AddTeamPageComponent;
  let fixture: ComponentFixture<AddTeamPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddTeamPageComponent]
    });
    fixture = TestBed.createComponent(AddTeamPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
