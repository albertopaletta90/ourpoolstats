import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoinMarketInfoComponent } from './coin-market-info.component';

describe('CoinMarketInfoComponent', () => {
  let component: CoinMarketInfoComponent;
  let fixture: ComponentFixture<CoinMarketInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoinMarketInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoinMarketInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
