import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyApiService {
  private baseUrl = 'http://localhost:8080'; // Replace with your Spring Boot API base URL

  constructor(private http: HttpClient) { }

  // getEmployeesList GET request
  getEmployeesList(): Observable<any> {
    const url = `${this.baseUrl}/api/users/all`; // Replace with your actual endpoint URL
    return this.http.get(url);
  }

  // Example POST request
  postData(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/postEndpoint`; // Replace with your actual endpoint URL
    return this.http.post(url, data);
  }

  addEmployee(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/users/add`; // Replace with your actual endpoint URL
    return this.http.post(url, data);
  }

  // getEmployeesList GET request

  getGroupList(): Observable<any> {
    const url = `${this.baseUrl}/api/groups/all`; // Replace with your actual endpoint URL
    return this.http.get(url);
  }
  getDepartmentList(): Observable<any> {
    const url = `${this.baseUrl}/api/departments/all`; // Replace with your actual endpoint URL
    return this.http.get(url);
  }


  //team apis

  getTeamList(): Observable<any> {
    const url = `${this.baseUrl}/api/teams/all`; // Replace with your actual endpoint URL
    return this.http.get(url);
  }

  addTeam(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/teams/add`; // Replace with your actual endpoint URL
    return this.http.post(url, data);
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

}
