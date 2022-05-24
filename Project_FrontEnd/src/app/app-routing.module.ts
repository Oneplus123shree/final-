import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreatePlayerComponent } from './create-player/create-player.component';
import { CreateTeamComponent } from './create-team/create-team.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ShowPlayerComponent } from './show-player/show-player.component';
import { ShowTeamComponent } from './show-team/show-team.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'loginsuccess',component:HomepageComponent},
  {path:'registration',component:RegistrationComponent},
  {path:'registersuccess',component:HomepageComponent},
  {path:'createTeam',component:CreateTeamComponent},
  {path:'createPlayer',component:CreatePlayerComponent},
  {path:'ShowTeam',component:ShowTeamComponent},
  {path:'ShowPlayer',component:ShowPlayerComponent},
  {path:'login',component:LoginComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
