import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-menu-ourpoolstats',
  templateUrl: './menu-ourpoolstats.component.html',
  styleUrls: ['./menu-ourpoolstats.component.css']
})
export class MenuOurpoolstatsComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

   goToHome = function() {
     this.router.navigate(['dashboard']);    
  };

  goToMarket = function(){
    this.router.navigate(['market']);    
  }

  goToForum = function(){
    this.router.navigate(['forum']);
  }

  goToAccount = function(){
    this.router.navigate(['account']);
  }

  goToPortfolio = function(){
    this.router.navigate(['portfolio']);
  }
}
