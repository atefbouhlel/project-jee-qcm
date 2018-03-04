import { Injectable } from '@angular/core';
import {AuthenticationService} from "./authentication.service";
import {Http, Headers} from "@angular/http";
import {Student} from "../models/Student";

@Injectable()
export class AdminService {

  private apiAdminUrl = 'http://localhost:8080/admin';


  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': 'Bearer ' + this.authenticationService.getToken()
  });

  constructor(
    private http: Http,
    private authenticationService: AuthenticationService
  ) {

  }

  getAllStudents() {
    return this.http.get(this.apiAdminUrl + '/students', {headers: this.headers})
      .map(resp => resp.json());
  }

  createStudent(newStudent): Promise<Student> {
    console.log("stu");
    console.log(newStudent);
    return this.http
      .post(this.apiAdminUrl + '/students/create', JSON.stringify(newStudent), {headers: this.headers})
      .toPromise()
      .then(res => res.json())
      .catch(this.handleError);
  }

  updateStudent(student: Student): Promise<Student> {
    console.log('----------');
    console.log(student);
    return this.http
      .post(this.apiAdminUrl + '/students/update/' + student.id, JSON.stringify(student), {headers: this.headers})
      .toPromise()
      .then(() => student)
      .catch(this.handleError);
  }

  updateStudent2(student: Student): Promise<Student> {
    return this.http
      .put(this.apiAdminUrl + '/students/' + student.id, JSON.stringify(student), {headers: this.headers})
      .toPromise()
      .then(() => student)
      .catch(this.handleError);
  }

  deleteStudent(id: number): Promise<void> {

    return this.http
      .get(this.apiAdminUrl + '/students/delete/' + id, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  deleteStudent2(id: number): Promise<void> {
    console.log(`hero.service - deleting ${id}`);
    return this.http
      .delete(this.apiAdminUrl + '/students/' + id, {headers: this.headers})
      .toPromise()
      .then(() => null)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred: ', error); // for demo only
    return Promise.reject(error.message || error);
  }

}
