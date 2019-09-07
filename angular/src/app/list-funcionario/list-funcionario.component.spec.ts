import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListFuncionarioComponent } from './list-funcionario.component';

describe('ListFuncionarioComponent', () => {
  let component: ListFuncionarioComponent;
  let fixture: ComponentFixture<ListFuncionarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListFuncionarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListFuncionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
