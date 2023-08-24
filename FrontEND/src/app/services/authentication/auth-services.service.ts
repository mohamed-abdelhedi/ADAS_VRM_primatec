import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthServicesService {

  private apiUrl = 'http://localhost:8080'; // Replace with your actual backend URL

  constructor(private http: HttpClient) { }

  login(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/v1/auth/authenticate`, data);
  }

  register(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/api/v1/auth/register`, data);
  }
}
