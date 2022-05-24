import { HttpClient,HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Player } from './player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {
  getPlayerById(playerId: number) {
    throw new Error('Method not implemented.');
  }
  playerNames: number | undefined;
  
  teamName:string |undefined;
  

  constructor(private _http:HttpClient) { }

  public createPlayerFromRemote(player:Player):Observable<any>
  {
    return this._http.post("http://localhost:8083/createPlayer",player);
  }
  private baseURL="http://localhost:8083/playerDetails";
  
  getPlayerByName(playerName:string):Observable<any>
  {
    return this._http.get<Player>(`${this.baseURL}/${playerName}`);
  }

  public getPlayerByTeamName(teamName?:string):Observable<any>
  {
    return this._http.get<any>("http://localhost:8083/players/"+teamName)
  }
 
}

