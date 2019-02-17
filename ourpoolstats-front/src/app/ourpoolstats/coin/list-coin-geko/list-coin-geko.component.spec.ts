import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCoinGekoComponent } from './list-coin-geko.component';

describe('ListCoinGekoComponent', () => {
  let component: ListCoinGekoComponent;
  let fixture: ComponentFixture<ListCoinGekoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCoinGekoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCoinGekoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
