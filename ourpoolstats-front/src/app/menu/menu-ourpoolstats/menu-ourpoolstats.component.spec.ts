import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuOurpoolstatsComponent } from './menu-ourpoolstats.component';

describe('MenuOurpoolstatsComponent', () => {
  let component: MenuOurpoolstatsComponent;
  let fixture: ComponentFixture<MenuOurpoolstatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuOurpoolstatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuOurpoolstatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
