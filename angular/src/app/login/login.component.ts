import { Component, OnInit } from '@angular/core';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor( private router: Router,private basicAuthenticationService: BasicAuthenticationService) { }

  email = 'admin@admin.com'
  senha = 'admin'
  errorMessage = 'Invalid Credentials'
  invalidLogin = false
  ngOnInit() {
  }

 

  handleJWTAuthLogin() {
    this.basicAuthenticationService.executeJWTAuthenticationService(this.email, this.senha)
        .subscribe(
          data => {
            console.log(this.email,this.senha)
           
            this.router.navigate(['clientes'])
            this.invalidLogin = false      
          },
          error => {
            console.log(error)
            this.invalidLogin = true
          }
        )
  }

}
