import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerStudentQcmComponent } from './answer-student-qcm.component';

describe('AnswerStudentQcmComponent', () => {
  let component: AnswerStudentQcmComponent;
  let fixture: ComponentFixture<AnswerStudentQcmComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerStudentQcmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerStudentQcmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
