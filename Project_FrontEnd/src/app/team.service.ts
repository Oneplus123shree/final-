import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from './team';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  
  constructor(private _http:HttpClient) { }

  getAllTeamName():any{
     return this._http.get<any>("http://localhost:8083/teamName");
  }

  public createTeamFromRemote(team:Team):Observable<any>
  {
    return this._http.post<any>("http://localhost:8083/createTeam",team);
  }




}
