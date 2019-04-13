import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {RequestOptions, Request, RequestMethod} from '@angular/http';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  Headers headers = new Headers({'Content-Type': 'application/json'});  
  headers.append('Authorization','Bearer ')
  options = new RequestOptions({headers: headers});

  private baseUrl = 'http://localhost:8088/SpringRESTEx'
  constructor(private http: HttpClient) { }

  

  getEmployee(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}/employees`,employee);
  }

  updateEmployee(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}/employees`);
  }
}
