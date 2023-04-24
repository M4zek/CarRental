import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RegisterService} from "../../service/register.service";
import {first} from "rxjs";
import {AlertService} from "../../service/alert.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{

  loginForm: FormGroup;


  constructor(    private formBuilder: FormBuilder,
                  private registerService: RegisterService,
                  private alertService: AlertService) {
  }

  ngOnInit(): void{
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', Validators.required],
      roles: ['', Validators.required],
      first_name: ['', Validators.required],
      last_name: ['', Validators.required]
    })
  }

  register(username: string, password: string, email: string, first_name: string, last_name: string){
    this.registerService.authenticate(
      username,
      password,
      email,
      first_name,
      last_name
    ).pipe(first())
      .subscribe(data =>{
        console.log(data);
      },
      error => {
      this.alertService.error(error);
    })
  }

}
