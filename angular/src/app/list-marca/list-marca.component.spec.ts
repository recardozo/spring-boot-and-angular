import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListMarcaComponent } from './list-marca.component';

describe('MarcaComponent', () => {
  let component: ListMarcaComponent;
  let fixture: ComponentFixture<ListMarcaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListMarcaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListMarcaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
