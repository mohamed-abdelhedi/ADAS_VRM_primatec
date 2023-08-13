import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignUserJobComponent } from './assign-user-job.component';

describe('AssignUserJobComponent', () => {
  let component: AssignUserJobComponent;
  let fixture: ComponentFixture<AssignUserJobComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AssignUserJobComponent]
    });
    fixture = TestBed.createComponent(AssignUserJobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
