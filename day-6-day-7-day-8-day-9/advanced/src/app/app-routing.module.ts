import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { AboutHistoryComponent } from './componenets/about-history/about-history.component';
import { AboutTeamComponent } from './componenets/about-team/about-team.component';
import { AboutPageComponent } from './pages/about-page/about-page.component';
import { ArticleDetailsPageComponent } from './pages/article-details-page/article-details-page.component';
import { AuthPageComponent } from './pages/auth-page/auth-page.component';
import { ContactPageComponent } from './pages/contact-page/contact-page.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';


const routes: Routes = [
  { path:'', redirectTo:'home', pathMatch:'full' },
  { path:'home', component:HomePageComponent, canActivate:[AuthGuard] },
  { path:'about', component:AboutPageComponent, canActivate:[AuthGuard]  ,
  
  children:[

    { path:'team', component:AboutTeamComponent },
    { path:'history', component:AboutHistoryComponent },
    
  ] },


  { path:'contact', component:ContactPageComponent , canActivate:[AuthGuard]  },
  

  { path:'article-details/:id', component:ArticleDetailsPageComponent  , canActivate:[AuthGuard] },
  
  { path:'auth', component:AuthPageComponent   },
  


  // wild card
  { path:'**', component: NotFoundComponent  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
