import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-options',
  templateUrl: './menu-options.component.html',
  styleUrls: ['./menu-options.component.css']
})
export class MenuOptionsComponent implements OnInit {

  typeUser : String = sessionStorage.getItem('typeUser');
  constructor(private router: Router) {}

  ngOnInit() {}

  goToCreateUser = function() {
    this.router.navigate(['createUser']);
  };

  goToDeleteUser = function(){  
    this.router.navigate(['deleteUser']);

  };

  goToChangeTypeUser = function(){
    this.router.navigate(['changeTypeUser']);
  };



}
