import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApxColumnComponent } from './apx-column.component';

describe('ApxColumnComponent', () => {
  let component: ApxColumnComponent;
  let fixture: ComponentFixture<ApxColumnComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApxColumnComponent]
    });
    fixture = TestBed.createComponent(ApxColumnComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
