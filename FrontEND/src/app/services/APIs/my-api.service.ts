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

  constructor(private http: HttpClient) {
  }


  // getEmployeesList GET request
  getEmployeesList(): Observable<any> {
    const headers = {"Authorization": "Bearer " + this.token};
    const url = `${this.baseUrl}/api/users/all`;
    return this.http.get(url, {headers});
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
      axios.get(url, {headers})
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
    return this.http.post(url, data, {headers});
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
    return this.http.get(url, {headers});
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

  getSkillbyid(id: string): Observable<any> {
    const url = `${this.baseUrl}/api/skills/${id}`;
    return this.http.get(url);
  }

  adduserSkills(userid: string, data: any): Observable<any> {
    const url = `${this.baseUrl}/api/user-skills/add/${userid}`;
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
    return this.http.get(url, {headers});
  }

  //Project team api
  assignProjectToTeam(teamId: string, projectId: string): Observable<any> {
    const url = `${this.baseUrl}/api/teams/${teamId}/assign-projects`;
    const requestBody = {"projectIds": [projectId]};
    return this.http.put(url, requestBody);
  }

  //skills API

  getUserSkills(skillid: string): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}`);
    const url = `${this.baseUrl}/api/user-skills/${skillid}`;
    return this.http.get(url, {headers});
  }

  getalluserSKILLS(userid: string): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}`);
    const url = `${this.baseUrl}/api/user-skills/user/${userid}`;
    return this.http.get(url, {headers});
  }

// workload API
  addWorkload(data: any): Observable<any> {
    const url = `${this.baseUrl}/api/workload/add`;
    return this.http.post(url, data);
  }

  assignWorkloadtoProject(workloadId: string, requestBody: any): Observable<any> {
    const url = `${this.baseUrl}/api/workload/${workloadId}/assign`;
    return this.http.put(url, requestBody);
  }

  assignWorkloadSkills(workloadId: string, requestBody: any): Observable<any> {
    const url = `${this.baseUrl}/api/workload/${workloadId}/assignskills`;
    return this.http.put(url, requestBody);
  }

  getWorkload(projectid: string): Observable<any> {
    const headers = new HttpHeaders().set('Authorization', `Bearer ${this.token}`);
    const url = `${this.baseUrl}/api/workload/project/${projectid}`;
    return this.http.get(url, {headers});
  }

  getUserSkillProficiency(userId: string, skillId: string): Observable<Object[]> {
    const url = `${this.baseUrl}/api/user-skills/proficiency?userId=${userId}&skillId=${skillId}`;
    return this.http.get<Object[]>(url);
  }

  getGraph(userId: string, skillId: string): Observable<Object[]> {
    const url = `${this.baseUrl}/api/user-skills/graph?userId=${userId}&skillId=${skillId}`;
    return this.http.get<Object[]>(url);
  }

  UpdataWorkload(workloadId: string, requestBody: any): Observable<any> {
    const url = `${this.baseUrl}/api/workload/${workloadId}`;
    return this.http.put(url, requestBody);
  }

  getWorkloadSkills(workloadid: string): Observable<Object[]> {
    const url = `${this.baseUrl}/api/workload/skills/${workloadid}`;
    return this.http.get<Object[]>(url);
  }

  UpdateUserskill(userSkillId: string, requestBody: any): Observable<any> {
    const url = `${this.baseUrl}/api/user-skills/${userSkillId}`;
    return this.http.put(url, requestBody);
  }

  getUserSkillID(skillid: string, userid: string): Observable<Object[]> {
    const url = `${this.baseUrl}/api/user-skills/getUserSkillIds?userId=${userid}&skillId=${skillid}`;
    return this.http.get<Object[]>(url);
  }

  getUserSkillForPreviousMonth(skillid: string, userid: string): Observable<Object[]> {
    const url = `${this.baseUrl}/api/user-skills/getUserSkillForPreviousMonth?userId=${userid}&skillId=${skillid}`;
    return this.http.get<Object[]>(url);
  }
  getDomainList(): Observable<any> {
    const url = `${this.baseUrl}/api/domain/all`;
    return this.http.get(url);
  }

  getPercentage(userId:string): Observable<any> {
    const url = `${this.baseUrl}/api/workload/percentage/${userId}`;
    return this.http.get(url);
  }

  sumworkload(): Observable<any> {
    const url = `${this.baseUrl}/api/workload/sum`;
    return this.http.get(url);
  }
  sumProject(): Observable<any> {
    const url = `${this.baseUrl}/api/projects/sum`;
    return this.http.get(url);
  }
  sumProjectByTeam(teamid:string): Observable<any> {
    const url = `${this.baseUrl}/api/projects/sumByTeam/${teamid}`;
    return this.http.get(url);
  }
  sumUser(): Observable<any> {
    const url = `${this.baseUrl}/api/users/sum`;
    return this.http.get(url);
  }
}
