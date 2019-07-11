import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { GenericResponse } from '../../model/model';
import { getLink } from 'src/app/app.module';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  
  username : string = sessionStorage.getItem('username');
  image : string;
  alert : boolean = false;
  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe((params) => this.alert = params.activeAlert);
    this.http.post<GenericResponse>(getLink()+`/getImage/${this.username}`,{}).
      subscribe(data => {
        this.image = data.data[0];
      }, error => {    
    });
  }

}
