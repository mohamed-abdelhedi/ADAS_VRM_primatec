import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDepartmentPageComponent } from './add-department-page.component';

describe('AddDepartmentPageComponent', () => {
  let component: AddDepartmentPageComponent;
  let fixture: ComponentFixture<AddDepartmentPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddDepartmentPageComponent]
    });
    fixture = TestBed.createComponent(AddDepartmentPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
