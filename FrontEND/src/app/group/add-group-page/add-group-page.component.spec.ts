import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGroupPageComponent } from './add-group-page.component';

describe('AddGroupPageComponent', () => {
  let component: AddGroupPageComponent;
  let fixture: ComponentFixture<AddGroupPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddGroupPageComponent]
    });
    fixture = TestBed.createComponent(AddGroupPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
