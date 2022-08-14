import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';
import { AuthComponent } from './auth.component';
import { SigninComponent } from './signin/signin.component';
import { SignipComponent } from './signip/signip.component';


@NgModule({
  declarations: [AuthComponent, SigninComponent, SignipComponent],
  imports: [
    CommonModule,
    AuthRoutingModule
  ]
})
export class AuthModule { }
