import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { AppConfig } from "../../config/app.config";
import { UserData } from "./model/userData.model";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  public authenticate(code: string) {
    return this.http.get<UserData>(AppConfig.backendUrl + '/login?code=' + code);
  }
}
