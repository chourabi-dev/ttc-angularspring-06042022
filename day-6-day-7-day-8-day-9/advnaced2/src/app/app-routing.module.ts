import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './pages/cart/cart.component';
import { HomeComponent } from './pages/home/home.component';
import { UsersComponent } from './pages/users/users.component';


const routes: Routes = [
  { path:'', redirectTo:'home', pathMatch:'full' },
  { path:'home', component:HomeComponent },
  { path:'cart', component:CartComponent },

  { path:'users', component:UsersComponent },

  
  
  { path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule) },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
