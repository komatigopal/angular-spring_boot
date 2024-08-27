import { Component } from '@angular/core';
import { JwtService } from 'src/app/service/jwt.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {


  message: string;

  constructor(
    private router: Router,
    private service: JwtService
  ) { }

  ngOnInit() {
    this.checkAuthenticated();
    this.hello();
    this.test();
  }

  checkAuthenticated() {
    let authenticated = localStorage.getItem('authenticated');
    console.log("authenticated - ", authenticated)
    if (authenticated && authenticated == 'true') {
      return true;
    } else {
      this.router.navigateByUrl("/login");
      return false;
    }
  }

  hello() {
    this.service.hello().subscribe(
      (response) => {
        console.log(response);
        this.message = response.message;
      }
    )
  }

  test(){
    this.service.getRoles().subscribe(
      (response) => {
        console.log(response);
        this.message = response.message;
      }
    )
  }
}
