import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartecipantComponent } from './partecipant.component';

describe('PartecipantComponent', () => {
  let component: PartecipantComponent;
  let fixture: ComponentFixture<PartecipantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartecipantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartecipantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
