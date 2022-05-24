import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Team } from '../team';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.css']
})
export class CreateTeamComponent implements OnInit {
  team=new Team();
  msg='';

  constructor(private _service:TeamService,private _router:Router) { }

  ngOnInit(): void {
  }

  createTeam(){

    this._service.createTeamFromRemote(this.team).subscribe(
      data=>{
        console.log("response received");
        this.msg="Successfully Created";
        alert("Successfully created team "+this.team.teamName)
        this._router.navigate(['/loginsuccess'])
      },
      error=> 
      {
        console.log("exception occured");
        this.msg="Team Name already exist";
      }
    )

  }

}
