import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GraphicCoinMarketComponent } from './graphic-coin-market.component';

describe('GraphicCoinMarketComponent', () => {
  let component: GraphicCoinMarketComponent;
  let fixture: ComponentFixture<GraphicCoinMarketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GraphicCoinMarketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GraphicCoinMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
