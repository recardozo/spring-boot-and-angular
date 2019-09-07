import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { BasicAuthenticationService } from './basic-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterAuthService  implements HttpInterceptor{




  constructor( private basicAuthenticationService : BasicAuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler){
    let basicAuthHeaderString = this.basicAuthenticationService.getAuthenticatedToken();
    let username = this.basicAuthenticationService.getAuthenticatedUser()

    if(basicAuthHeaderString && username) { 
      console.log(basicAuthHeaderString)
      console.log(username)
      request = request.clone({
        setHeaders : {
            Authorization : 'Authorization'
          }
        }) 
        
    }
    return next.handle(request);
  }
}
