import { Component, OnInit } from '@angular/core';
import { AppConfig } from "../../../config/app.config";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  githubLoginUrl: string = AppConfig.github.authUrl +
    '?client_id=' + AppConfig.github.clientId +
    '&redirect_uri=' + AppConfig.github.redirectUrl +
    '&scope=' + AppConfig.github.scope;

  constructor() { }

  ngOnInit() { }

}
