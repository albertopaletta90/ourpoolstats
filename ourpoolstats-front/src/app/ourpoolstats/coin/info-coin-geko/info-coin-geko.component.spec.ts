import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoCoinGekoComponent } from './info-coin-geko.component';

describe('InfoCoinGekoComponent', () => {
  let component: InfoCoinGekoComponent;
  let fixture: ComponentFixture<InfoCoinGekoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfoCoinGekoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoCoinGekoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
