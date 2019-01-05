import { Component, OnInit, Inject } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { LoginFormComponent } from '../login-form/login-form.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  openLoginForm() {
    const dialogRef = this.dialog.open(LoginFormComponent, {
        width: '500px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
