import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthenticateService} from "../../service/authenticate.service";
import {ActivatedRoute, Router} from "@angular/router";
import {first} from "rxjs";
import {AlertService} from "../../service/alert.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
    private formBuilder: FormBuilder,
    private authenticateService: AuthenticateService,
    private route: ActivatedRoute,
    private router: Router,
    private alertService: AlertService
  ) {
    // if(this.authenticateService.currentUserValue){
    //   this.router.navigate(['main']);
    // }

    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    })
  }


  onSubmit(username: string, password: string) {
    this.authenticateService.authenticate(username, password)
      .pipe(first())
      .subscribe(
        data => {
          this.router.navigate(['main']);
        },
        error => {
          this.alertService.error(error);
          this.loading = false;
        }
      )
  }
}
