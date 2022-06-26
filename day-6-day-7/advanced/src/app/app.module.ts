import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { AboutPageComponent } from './pages/about-page/about-page.component';
import { ContactPageComponent } from './pages/contact-page/contact-page.component';
import { NavbarComponent } from './componenets/navbar/navbar.component';
import { AboutHistoryComponent } from './componenets/about-history/about-history.component';
import { AboutTeamComponent } from './componenets/about-team/about-team.component';
import { ArticleDetailsPageComponent } from './pages/article-details-page/article-details-page.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { AuthPageComponent } from './pages/auth-page/auth-page.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    AboutPageComponent,
    ContactPageComponent,
    NavbarComponent,
    AboutHistoryComponent,
    AboutTeamComponent,
    ArticleDetailsPageComponent,
    NotFoundComponent,
    AuthPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
