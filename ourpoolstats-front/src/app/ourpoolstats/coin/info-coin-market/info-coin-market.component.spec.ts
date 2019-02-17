import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoCoinMarketComponent } from './info-coin-market.component';

describe('InfoCoinMarketComponent', () => {
  let component: InfoCoinMarketComponent;
  let fixture: ComponentFixture<InfoCoinMarketComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfoCoinMarketComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoCoinMarketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
