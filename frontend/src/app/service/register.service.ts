import { Injectable } from '@angular/core';
import {map} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {



  constructor(private http: HttpClient) { }

  authenticate(username: string, password: string, email: string, first_name: string, last_name: string){
    let roles = Array.from(["USER"])
    return this.http.post<any>('http://localhost:8080/api/auth/register', { username, password, email, roles, first_name, last_name })
      .pipe(map(result =>{

      return result;
      }));
  }

}
