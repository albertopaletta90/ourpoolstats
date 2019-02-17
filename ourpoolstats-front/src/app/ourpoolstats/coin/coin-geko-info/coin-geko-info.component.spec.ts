import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoinGekoInfoComponent } from './coin-geko-info.component';

describe('CoinGekoInfoComponent', () => {
  let component: CoinGekoInfoComponent;
  let fixture: ComponentFixture<CoinGekoInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoinGekoInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoinGekoInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
