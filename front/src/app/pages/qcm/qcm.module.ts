import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { QcmRoutingModule } from './qcm.routing';
import { QcmComponent } from './qcm.component';
import { ConfigComponent } from './config/config.component';
import { ComponentsModule } from '../../components/components.module';
import { QuestionsComponent } from './questions/questions.component';
import { UsersComponent } from './users/users.component';
import { MyDatePickerModule } from 'angular4-datepicker/src/my-date-picker';
import { ListQcmComponent } from './list-qcm/list-qcm.component';
import { UEComponent } from './ue/ue.component';
import {FormsModule} from "@angular/forms";
import {PopupModule} from 'ng2-opd-popup';
import { ListStudentQcmComponent } from './list-student-qcm/list-student-qcm.component';
import { AnswerStudentQcmComponent } from './answer-student-qcm/answer-student-qcm.component';

@NgModule({
  imports: [
    MyDatePickerModule,
    CommonModule,
    RouterModule,
    ComponentsModule,
    QcmRoutingModule,
    FormsModule,
    PopupModule.forRoot()
  ],
  declarations: [QcmComponent, ConfigComponent, QuestionsComponent, UsersComponent, ListQcmComponent, UEComponent, ListStudentQcmComponent, AnswerStudentQcmComponent]
})
export class QcmModule { }
