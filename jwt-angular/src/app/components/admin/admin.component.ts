import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtService } from 'src/app/service/jwt.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit{
  adminForm: FormGroup | undefined;
  constructor(
    private service: JwtService,
    private fb: FormBuilder
  ) { }
  ngOnInit(): void {
    this.adminForm = this.fb.group({
      url: ['', Validators.required],
      displayName: ['', Validators.required],
    })
  }

  submitForm() {
    this.service.saveNavigation(this.adminForm.value).subscribe(
      (response) => {
        console.log(response);
      });
    }

}
