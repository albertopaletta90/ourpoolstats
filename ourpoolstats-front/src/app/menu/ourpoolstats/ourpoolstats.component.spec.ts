import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OurpoolstatsComponent } from './ourpoolstats.component';

describe('OurpoolstatsComponent', () => {
  let component: OurpoolstatsComponent;
  let fixture: ComponentFixture<OurpoolstatsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OurpoolstatsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OurpoolstatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
