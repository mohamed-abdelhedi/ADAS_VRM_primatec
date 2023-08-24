import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
import axios from "axios";

@Injectable({
  providedIn: 'root'
})
export class MyApiService {
  private baseUrl = 'http://localhost:8080';

  token = localStorage.getItem('access_token');
  headers = {"Authorization": "Bearer " + this.token};

  constructor(private http: HttpClient) { }


  // getEmployeesList GET request
  getEmployeesList(): Observable<any> {
    const  headers = {"Authorization": "Bearer " + this.token};
    const url = `${this.baseUrl}/api/users/all`;
    return this.http.get(url,{  headers });
  }


  addEmployee(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/users/add`;
    return this.http.post(url, data);
  }

  //team apis

  getTeamList(): Observable<any> {
    const headers = {"Authorization": "Bearer " + this.token};
    const url = `${this.baseUrl}/api/teams/all`;
    return new Observable((observer) => {
      axios.get(url,{headers})
        .then((response) => {
          observer.next(response.data);
          observer.complete();
        })
        .catch((error) => {
          observer.error(error);
        });
    });
  }


  addTeam(data: any): Observable<any> {
    const headers = {"Authorization": "Bearer " + this.token};
    const url = `${this.baseUrl}/api/teams/add`; // Replace with your actual endpoint URL
    return this.http.post(url, data,{headers});
  }
//Project api

  getJobList(): Observable<any> {
    const url = `${this.baseUrl}/api/projects/all`; // Replace with your actual endpoint URL
    return this.http.get(url);
  }

  addJob(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/projects/add`; // Replace with your actual endpoint URL
    return this.http.post(url, data);
  }

  //Department api
  getDepartmentList(): Observable<any> {
    const headers = {"Authorization": "Bearer " + this.token};
    const url = `${this.baseUrl}/api/departments/all`;
    return this.http.get(url,{headers});
  }

  addDepartment(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/departments/add`;
    return this.http.post(url, data);
  }
//group api
  getGroupList(): Observable<any> {
    const url = `${this.baseUrl}/api/groups/all`;
    return this.http.get(url);
  }

  addGroup(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/groups/add`;
    return this.http.post(url, data);
  }

  //Skill api

  getSkillList(): Observable<any> {
    const url = `${this.baseUrl}/api/skills/all`;
    return this.http.get(url);
  }
  adduserSkills(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/user-skills/add/a6228c95-dbfd-4531-83bb-8fd72380661d`;
    return this.http.post(url, data);
  }
  //test api
  test(): Observable<any> {
    const url = `${this.baseUrl}/api/v1/demo-controller`;
    return this.http.get(url);
  }

  //Profile Api Calls

  getUserProfile(userId: string): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}`);
    const url = `${this.baseUrl}/api/users/${userId}`;
    return this.http.get(url, { headers });
  }


}
