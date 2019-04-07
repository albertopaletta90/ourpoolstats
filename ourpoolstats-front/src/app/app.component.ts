import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ourpoolstats-front';
  
  constructor(private translate: TranslateService) {
    translate.setDefaultLang('commons');
  }

  public switchLanguage(language: string) {
    this.translate.use(language);
   
}

}
