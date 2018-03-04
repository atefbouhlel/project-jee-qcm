import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListStudentQcmComponent } from './list-student-qcm.component';

describe('ListStudentQcmComponent', () => {
  let component: ListStudentQcmComponent;
  let fixture: ComponentFixture<ListStudentQcmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListStudentQcmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListStudentQcmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
