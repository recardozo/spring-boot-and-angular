import { Component, OnInit } from '@angular/core';
import { Departamento } from '../shared/departamento.model';
import { DepartamentoService } from '../service/departamento.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-departamento',
  templateUrl: './list-departamento.component.html',
  styleUrls: ['./list-departamento.component.css']
})
export class ListDepartamentoComponent implements OnInit {

  message: string;
  departamentos: Departamento[];

  constructor(private departamentoService: DepartamentoService, private router: Router) { }

  ngOnInit() {
    this.refreshDepartamentos();
  }

  refreshDepartamentos() {
    this.departamentoService.listDepartamentos().subscribe(
      response => {
        this.departamentos = response;
        console.log(this.departamentos)
      }
    );
  }

  deleteDepartamento(id) {
    this.departamentoService.deleteDepartamento(id).subscribe(
      response => {
        console.log(response);
        this.message = `Departamento ${id} has been deleted!`;
        this.refreshDepartamentos();
      }
    )
  }


  updateDepartamento(id) {
    console.log(`Departamento ${id} has been updated!`);
    this.router.navigate(['departamentos', id]);
  }

  addDepartamento() {
    this.router.navigate(['departamentos', -1]);
  }
}
