import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserIdleService } from 'angular-user-idle';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  constructor(
    private userIdle: UserIdleService,
    private router: Router
  ) { }
  title = 'jwt-angular';
  userEmail = null;
  timeLeft: number = 60;
  interval;

  ngOnInit(): void {
    localStorage.setItem('authenticated', 'false');
    this.checkAuthenticated();
    this.router.navigateByUrl("/login");
    this.idleTime();
  }

  idleTime(){   
    this.userIdle.onTimerStart().subscribe(count => console.log("count - ", count));
    this.userIdle.onTimeout().subscribe(() => {
      console.log('Time is up!');
      this.logout();
      this.userIdle.resetTimer();
    });
  }

  checkAuthenticated() {
    let authenticated = localStorage.getItem('authenticated');
    if (authenticated && authenticated == 'true') {
      var username = localStorage.getItem('username');
      if(username){
        this.userEmail = username;
      }
      return true;
    } else {
      return false;
    }
  }

  logout() {
    localStorage.setItem('authenticated', 'false');
    localStorage.setItem('username', null);
    this.userEmail = localStorage.getItem('username');
    let authenticated = localStorage.getItem('authenticated');
    if (authenticated && authenticated == 'true') {
      return true;
    } else {
      this.router.navigateByUrl("/login");
      return false;
    }
  }
}
