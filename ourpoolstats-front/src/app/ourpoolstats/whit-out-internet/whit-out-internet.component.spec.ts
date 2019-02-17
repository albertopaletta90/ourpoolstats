import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WhitOutInternetComponent } from './whit-out-internet.component';

describe('WhitOutInternetComponent', () => {
  let component: WhitOutInternetComponent;
  let fixture: ComponentFixture<WhitOutInternetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WhitOutInternetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WhitOutInternetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
