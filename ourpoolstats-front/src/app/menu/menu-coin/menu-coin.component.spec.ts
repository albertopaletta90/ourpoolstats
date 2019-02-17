import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuCoinComponent } from './menu-coin.component';

describe('MenuCoinComponent', () => {
  let component: MenuCoinComponent;
  let fixture: ComponentFixture<MenuCoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuCoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuCoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
