import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkloadPageComponent } from './workload-page.component';

describe('WorkloadPageComponent', () => {
  let component: WorkloadPageComponent;
  let fixture: ComponentFixture<WorkloadPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WorkloadPageComponent]
    });
    fixture = TestBed.createComponent(WorkloadPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
