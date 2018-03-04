import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {QcmComponent} from "./qcm.component";
import {ConfigComponent} from "./config/config.component";
import {QuestionsComponent} from "./questions/questions.component";
import {UsersComponent} from "./users/users.component";
import {ListQcmComponent} from "./list-qcm/list-qcm.component";
import {AuthGuard} from "../../guards/auth.guard";
import {UEComponent} from "./ue/ue.component";
import {ListStudentQcmComponent} from "./list-student-qcm/list-student-qcm.component";
import {AnswerStudentQcmComponent} from "./answer-student-qcm/answer-student-qcm.component";

const routes: Routes = [
  { path: 'qcm',  component: QcmComponent, canActivateChild: [ AuthGuard ],
    children: [
      { path: 'config', component: ConfigComponent },
      { path: 'questions', component: QuestionsComponent },
      { path: 'ue', component: UEComponent },
      { path: 'users', component: UsersComponent },
      { path: 'all', component: ListQcmComponent },
      { path: 'list', component: ListStudentQcmComponent },
      { path: 'answer', component: AnswerStudentQcmComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QcmRoutingModule { }
