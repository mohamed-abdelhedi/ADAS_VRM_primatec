import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEmployeeNextComponent } from './add-employee-next.component';

describe('AddEmployeeNextComponent', () => {
  let component: AddEmployeeNextComponent;
  let fixture: ComponentFixture<AddEmployeeNextComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddEmployeeNextComponent]
    });
    fixture = TestBed.createComponent(AddEmployeeNextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
