import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from "../auth.service";
import { UserData } from "../model/userData.model";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  code: string;
  userData: UserData;

  constructor(private route: ActivatedRoute, private router: Router, private authService: AuthService) {
    this.route.queryParams.subscribe(params => {
      this.code = params['code'];
    });
  }

  ngOnInit() {
    this.authService.authenticate(this.code).subscribe(userData => {
      this.userData = userData;
      if (this.userData.user == null) {
        this.router.navigate(['/']);
      }
    });
  }

}
