import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef} from '@angular/material/dialog';

import { Person } from '../model/person';
import { RanyenService } from '../ranyen.service';

@Component({
  selector: 'app-signup-form',
  templateUrl: './signup-form.component.html',
  styleUrls: ['./signup-form.component.css']
})
export class SignupFormComponent implements OnInit {
    
  personInfoForm: FormGroup;

  hide = true; //used to indicate whether to hide passwords or not
    
  personInfo = new Person(null, null, null, null, null, null);

  constructor(private formBuilder: FormBuilder, 
               public dialogRef: MatDialogRef<SignupFormComponent>,
              public ranyenService: RanyenService) { 
    this.personInfoForm = this.createPersonFormGroup(formBuilder);
  }

  createPersonFormGroup(formBuilder: FormBuilder){
      return this.formBuilder.group({
          firstName: [this.personInfo.firstName, Validators.required],
          lastName: [this.personInfo.lastName, Validators.required],
          middleInitial: [this.personInfo.middleInitial],
          emailAddress: [this.personInfo.emailAddress, [Validators.required, Validators.email]],
          confirmEmail: [this.personInfo.emailAddress, Validators.required],
          username: [this.personInfo.username, Validators.required],
          password: [this.personInfo.password, Validators.required],
          confirmPassword: [this.personInfo.password, Validators.required]
      });
  }
    
  ngOnInit() {
  }

  onSubmit(dialogRef: MatDialogRef<SignupFormComponent>) {
    const newPerson: Person = JSON.parse(JSON.stringify(this.personInfoForm.value)); //deep copy the contents from the form to the Person object
    this.addPerson(newPerson);
    //TODO: if person successfully added, show alert box
    this.dialogRef.close(); //close dialog box
  } 
  
 addPerson(newPerson: Person){
    console.log("Inside add person");
    this.ranyenService.addUser(newPerson).subscribe((result) => {
      //this.router.navigate(['/add-user/'+result._id]);
      console.log("new person added: " + result.username );
    }, (err) => {
      console.log(err);
    });     
 }
}
