import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Player } from '../player';
import { PlayerService } from '../player.service';
import { Team } from '../team';
import { TeamService } from '../team.service';

@Component({
  selector: 'app-show-team',
  templateUrl: './show-team.component.html',
  styleUrls: ['./show-team.component.css']
})
export class ShowTeamComponent implements OnInit {

  

  teams=[];
  players:Player[]=[];
  
  player=new Player();

  
  constructor(private _router:Router,private service:TeamService,private service1:PlayerService) { }

  ngOnInit(): void {
     this.showAll();
  }

  showAll()
{
  return this.service.getAllTeamName().subscribe(
    (data:any)=>{
      this.teams=data,
    console.log( this.teams)}

  )
}

showTeam(tName :string)
  {
    
    return this.service1.getPlayerByTeamName(tName).subscribe(
      data =>
      {
        
        this.players=data;
       
      }
    );
  }

}
