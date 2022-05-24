import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { Team } from '../team';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-create-player',
  templateUrl: './create-player.component.html',
  styleUrls: ['./create-player.component.css']
})
export class CreatePlayerComponent implements OnInit {
  player=new Player();
  teams=[];
  
  constructor(private service:PlayerService,private _router:Router,private service1:TeamService) { }

  ngOnInit(): void {
    this.showAll();
  }

  createPlayer()
  {

    this.service.createPlayerFromRemote(this.player).subscribe(
      data =>{
        console.log("response received");
        this._router.navigate(['/loginsuccess'])},
      error=> 
      {
        console.log("exception occured");
      }
    )

}

showAll()
{
  this.service1.getAllTeamName().subscribe(
    (data:any)=>this.teams=data,
    console.log(this.teams)
  )
}
}
