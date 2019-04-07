import { Component, OnInit,Input } from '@angular/core';
import {Subject} from 'rxjs';
import {NgbAlertConfig} from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-alerts',
  templateUrl: './alerts.component.html',
  styleUrls: ['./alerts.component.css'],
  providers: [NgbAlertConfig]
})
export class AlertsComponent implements OnInit {
  @Input() public alerts: Array<string> = [];

  message : string;
  typeAlert : string;

  constructor(private route: ActivatedRoute,alertConfig: NgbAlertConfig) {
    this.route.params.subscribe((params) => this.typeAlert = params.typeAlert);
    this.route.params.subscribe((params) => this.message = params.message);
    this.setAlert(alertConfig);
  }
  
  ngOnInit() { }

  setAlert(alertConfig : NgbAlertConfig){
    alertConfig.type = this.typeAlert;
    alertConfig.dismissible = true;
    this.message = this.message;
  }

  
}
