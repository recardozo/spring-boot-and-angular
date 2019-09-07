import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { tap } from 'rxjs/operators';
import { API_URL } from '../app.constants';

export const TOKEN = 'Authorization'
export const AUTHENTICATED_USER = 'authenticaterUser'

@Injectable({
    providedIn: 'root'
})
export class BasicAuthenticationService {
    constructor(private http: HttpClient) { }

    executeJWTAuthenticationService(email, senha) {

        return this.http.post<any>(
            `${API_URL}/login`, {
                email,
                senha
            }, 
            {observe: 'response' as 'body'}
            ).pipe(
                map(
                    data => {

                         sessionStorage.setItem(AUTHENTICATED_USER, email);
                         sessionStorage.setItem(TOKEN, data.headers.get(TOKEN));
                        
                         console.log(data.headers.get('Authorization'))
                        return data;
                    }
                    
                )
            );
        
    }


   

    getAuthenticatedUser() {
        return sessionStorage.getItem(AUTHENTICATED_USER)
    }

    getAuthenticatedToken() {
        if (this.getAuthenticatedUser())
            return sessionStorage.getItem(TOKEN)
    }

  

    isUserLoggedIn() {
        let user = sessionStorage.getItem(AUTHENTICATED_USER)
        return !(user === null)
    }

    logout() {
        sessionStorage.removeItem(AUTHENTICATED_USER)
        sessionStorage.removeItem(TOKEN)
    }
}

export class BasicAuthenticationBean {
    constructor(public message: string) { }
} 
