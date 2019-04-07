import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LogUserResponse, UserLog } from '../../../model/model';

@Component({
  selector: 'app-list-user-log',
  templateUrl: './list-user-log.component.html',
  styleUrls: ['./list-user-log.component.css']
})
export class ListUserLogComponent implements OnInit {

  typeAlert: string;
  error: boolean;
  userLog: UserLog[];
  type: string;
  username : string;
  constructor(private route: ActivatedRoute,private http: HttpClient,private router: Router) {
    this.route.params.subscribe((data) => this.type = data.type);
    this.route.params.subscribe((data) => this.username = data.username);
    this.type == 'single' ? this.logToSingle() : this.logToAll();
  }

  ngOnInit() {
  }

  logToSingle(){
    this.http.get<LogUserResponse>(`http://localhost:8080/newourpoolstats/logSingleUser/${this.username}`).
    subscribe(data => {
      this.userLog = data.userLog;
  }, error => {
    this.error = true;
    this.typeAlert = 'danger'; 
  });
  }

  logToAll(){
    this.http.get<LogUserResponse>(`http://localhost:8080/newourpoolstats/logUser`).
    subscribe(data => {
      this.userLog = data.userLog;
  }, error => {
    this.error = true;
    this.typeAlert = 'danger'; 
  });

  }

  back(){
    this.router.navigate(['listUser']);
  }
  
}
