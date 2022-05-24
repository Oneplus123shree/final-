import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user=new User();
  msg='';
  formBuilder: any;
  constructor(private service:RegistrationService,private _router:Router) { }

  ngOnInit(): void {
  }

  registerUser()
  {

    this.service.registerUserFromRemote(this.user).subscribe(
      data =>{
        console.log("response received");
        this._router.navigate(['/registersuccess'])
        console.log("response Error");
        this.user = this.formBuilder.group({
          username: new FormControl('', Validators.required),
          email: new FormControl('', Validators.compose([
            Validators.required,
            Validators.pattern('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$')
          ]))
        });
      },
      error=> 
      {
        console.log("exception occured");
        this.msg="Username already exist";
      })

  }

}
