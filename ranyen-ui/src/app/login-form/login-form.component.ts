import { Component, OnInit, Inject } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
    
  private showAlert: boolean;
  private alertText; string; 
  hide = true; //used to indicate whether to hide passwords or not

  loginForm = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });
    
  constructor(public dialogRef: MatDialogRef<LoginFormComponent>) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log("Attempt to login with username: " + this.loginForm.value.username);
    if (this.showAlert){
        this.alertText = "Wrong username or password";
        this.showAlert = true;
    } else {
        this.dialogRef.close(); //close dialog box
    }
  } 
}
