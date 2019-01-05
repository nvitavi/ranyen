import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { SignupFormComponent } from "../signup-form/signup-form.component"

@Component({
  selector: 'app-header-menu',
  templateUrl: './header-menu.component.html',
  styleUrls: ['./header-menu.component.css']
})
export class HeaderMenuComponent implements OnInit {

  constructor(public dialog: MatDialog) { }

  ngOnInit() {
  }

  openSignUpForm() {
    const dialogRef = this.dialog.open(SignupFormComponent, {
        width: '800px',
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
    });
  }

}
