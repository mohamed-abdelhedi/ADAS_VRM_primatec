import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyApiService {
  private baseUrl = 'http://localhost:8080'; // Replace with your Spring Boot API base URL

  constructor(private http: HttpClient) { }

  // Example GET request
  getSomeData(): Observable<any> {
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
}
