import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Player } from '../player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-show-player',
  templateUrl: './show-player.component.html',
  styleUrls: ['./show-player.component.css']
})
export class ShowPlayerComponent implements OnInit {
  
  player: Player = new Player;
  players:Player[]=[];
  playerName: string='';
  
  constructor(private service:PlayerService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {

  }
  showPlayer()
  {  

     return this.service.getPlayerByName(this.playerName).subscribe(data=>
      {
        this.players=data;
        console.log(this.player)
      });
  }
}
