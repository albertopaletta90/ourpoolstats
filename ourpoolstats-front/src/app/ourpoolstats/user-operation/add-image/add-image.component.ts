import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { getLink } from 'src/app/app.module';

@Component({
  selector: 'app-add-image',
  templateUrl: './add-image.component.html',
  styleUrls: ['./add-image.component.css']
})
export class AddImageComponent implements OnInit {

  message: string;
  error: boolean;
  typeAlert: string;
  image : string;
  username : string = sessionStorage.getItem('username');
  
  constructor(private http: HttpClient, private router: Router,private route: ActivatedRoute) { }

  ngOnInit() {
  }

  addImage(){debugger
    this.http.post(getLink()+`/addImage/${this.image}/username/${this.username}`,{}).
    subscribe(data => {
      this.typeAlert = 'success';
      this.message = 'Immagine profilo cambiata correttamente';
      this.router.navigate(['account',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);
  }, error => {
    this.error = true;
      this.typeAlert = 'danger';
      this.message = 'Immagine profilo non cambiata';
      this.router.navigate(['account',{typeAlert: this.typeAlert,message : this.message,activeAlert : true}]);  
  });
  }

  back(){

  }
}
