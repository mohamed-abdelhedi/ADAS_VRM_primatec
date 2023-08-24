import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobStatisticComponent } from './job-statistic.component';

describe('JobStatisticComponent', () => {
  let component: JobStatisticComponent;
  let fixture: ComponentFixture<JobStatisticComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JobStatisticComponent]
    });
    fixture = TestBed.createComponent(JobStatisticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
