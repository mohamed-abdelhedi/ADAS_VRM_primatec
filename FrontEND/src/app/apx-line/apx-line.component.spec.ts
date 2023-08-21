import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApxLineComponent } from './apx-line.component';

describe('ApxLineComponent', () => {
  let component: ApxLineComponent;
  let fixture: ComponentFixture<ApxLineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ApxLineComponent]
    });
    fixture = TestBed.createComponent(ApxLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
