import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';
import { UserIdleService } from 'angular-user-idle';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup | undefined;
  authorities = []

  constructor(
    private service: JwtService,
    private fb: FormBuilder,
    private router: Router,
    private userIdle: UserIdleService
  ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required, Validators.email],
      password: ['', Validators.required],
    })
  }

  submitForm() {
    this.service.login(this.loginForm.value).subscribe(
      (response) => {
        console.log(response);
        if (response?.jwt != null) {
          const jwtToken = response.jwt;
          localStorage.setItem('jwt', jwtToken);
          localStorage.setItem('authenticated', 'true');
          this.userIdle.startWatching(); 
          if(response?.userDetails){
            var userDetails = response.userDetails;
            localStorage.setItem('username', userDetails.username);
            if(userDetails?.authorities){
              this.authorities = response.userDetails.authorities;
              const index: number = this.authorities.indexOf('admin');
              if (index !== -1){
                this.router.navigateByUrl("/dashboard");    
              } else {
                this.router.navigateByUrl("/admin");
              }
            }
          }
        } else {
          alert("something went wrong")
        }
      }
    )
  }

}
