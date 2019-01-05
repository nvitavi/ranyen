import { NgModule } from '@angular/core';

import { MatMenuModule } from '@angular/material/menu';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatTabsModule } from '@angular/material/tabs'; 
import { MatInputModule } from '@angular/material/input'; 

@NgModule({
  imports: [
    MatToolbarModule,
    MatMenuModule,
    MatDialogModule,
    MatIconModule,
    MatSidenavModule,
    MatCardModule,
    MatButtonModule,
    MatTabsModule,
    MatFormFieldModule ,
    MatInputModule
  ],
  exports: [
    MatToolbarModule,
    MatMenuModule,
    MatDialogModule,
    MatIconModule,
    MatSidenavModule,
    MatCardModule,
    MatButtonModule,
    MatTabsModule,
    MatFormFieldModule, 
    MatInputModule 
  ]
})
export class MaterialService {

  constructor() { }
}
