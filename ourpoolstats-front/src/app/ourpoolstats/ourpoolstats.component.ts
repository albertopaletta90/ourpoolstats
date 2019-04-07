import { Component, OnInit,Input } from '@angular/core';
import { LoginResponse, CoinGeko } from '../model/model';
import { LoginComponent } from '../login/login.component';
import { ActivatedRoute, Params } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-ourpoolstats',
  templateUrl: './ourpoolstats.component.html',
  styleUrls: ['./ourpoolstats.component.css'],

})
export class OurpoolstatsComponent implements OnInit {
  
  view : boolean = false;

  constructor(private route: ActivatedRoute) {
    this.route.params.subscribe((params) => this.view = params.activeAlert);
  }

  ngOnInit() {}

}
