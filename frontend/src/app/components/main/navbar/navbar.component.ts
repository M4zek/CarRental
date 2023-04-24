import {Component, OnInit} from '@angular/core';
import {User} from "../../../model/user";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  name_surname: string;

  ngOnInit(): void {
    // @ts-ignore
    let user = JSON.parse(localStorage.getItem('currentUser'));
    this.name_surname = user.firstName + " " + user.lastName + " | " + user.roles;
  }


}
