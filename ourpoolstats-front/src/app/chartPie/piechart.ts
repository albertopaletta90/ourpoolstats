import { Component } from '@angular/core';
 
@Component({
  selector: 'piechart',
  templateUrl: './piechart.html'
})
export class PieChartComponent {
  // Pie
  public pieChartLabels:string[] = ['Bitcoin', 'Verge', 'Tron'];
  public pieChartData:number[] = [200, 1000, 2000];
  public pieChartType:string = 'doughnut';

  // events
  public chartClicked(e:any):void {
    console.log(e);
  }
 
  public chartHovered(e:any):void {
    console.log(e);
  }

  public chartColors: Array<any> = [
    { // first color
      backgroundColor: 'rgba(225,10,24,0.2)',
      borderColor: 'rgba(225,10,24,0.2)',
      pointBackgroundColor: 'rgba(225,10,24,0.2)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(225,10,24,0.2)'
    },
    { // second color
      backgroundColor: 'rgba(225,10,24,0.2)',
      borderColor: 'rgba(225,10,24,0.2)',
      pointBackgroundColor: 'rgba(225,10,24,0.2)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(225,10,24,0.2)'
    }];
  
}

/*  type chart
  pie --> torta 
  doughnut --> cerchi
  polarArea 
  bar --> barre
  horizontalBar --> barre orizontali
  bubble  
  scatter
        
 * 
 */