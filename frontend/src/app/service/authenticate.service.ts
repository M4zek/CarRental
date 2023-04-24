import { Injectable } from '@angular/core';
import {BehaviorSubject, map, Observable} from "rxjs";
import {User} from "../model/user";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../environment/environment.prod";

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;

  constructor(private http: HttpClient) {
    // @ts-ignore
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
  }


  authenticate(username: string, password: string){
    return this.http.post<any>('http://localhost:8080/api/auth/authenticate', { username, password})
      .pipe(map(user =>{

        localStorage.setItem('currentUser', JSON.stringify(user));
        this.currentUserSubject.next(user);
        this.currentUser = user;
        console.log(this.currentUser)
        return user;
      }));
  }
}
