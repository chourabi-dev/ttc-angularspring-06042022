import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth-page',
  templateUrl: './auth-page.component.html',
  styleUrls: ['./auth-page.component.css']
})
export class AuthPageComponent implements OnInit {

  authForm = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
    
  })



  constructor(private router:Router) { }

  ngOnInit(): void {
  }


  connect(){
    const username = this.authForm.value.username;
    const password = this.authForm.value.password;


    if (username=== 'admin' && password ==='admin' ) {

      
      localStorage.setItem('jeton','connected');


      // redirection home page
      this.router.navigateByUrl('/home');
    } else {
      alert('wrong username or password');
    }
    

  }
}
