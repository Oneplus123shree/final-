import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomepageComponent } from './homepage/homepage.component';
import { CreateTeamComponent } from './create-team/create-team.component';
import { CreatePlayerComponent } from './create-player/create-player.component';
import { ShowTeamComponent } from './show-team/show-team.component';
import { ShowPlayerComponent } from './show-player/show-player.component';
import { PlayerService } from './player.service';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HomepageComponent,
    CreateTeamComponent,
    CreatePlayerComponent,
    ShowTeamComponent,
    ShowPlayerComponent,
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
    
  ],
  providers: [PlayerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
