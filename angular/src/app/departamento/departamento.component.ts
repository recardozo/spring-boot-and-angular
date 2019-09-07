import { Component, OnInit } from '@angular/core';
import { DepartamentoService } from '../service/departamento.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Departamento } from '../shared/departamento.model';

@Component({
  selector: 'app-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css']
})
export class DepartamentoComponent implements OnInit {

  constructor(private departamentoService: DepartamentoService, private route: ActivatedRoute, private router: Router) { }
  id: number;
  departamento: Departamento;
  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.departamento = new Departamento(this.id, '', '');
    if (this.id != -1) {
      this.departamentoService.getDepartamento(this.id).subscribe(
        response => this.departamento = response
      )
    }
  }


  saveDepartamento() {
    if (this.id == -1) {
      this.departamentoService.createDepartamento(this.departamento).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['departamentos'])
        }
      )
    } else {
      this.departamentoService.updateDepartamento(this.id, this.departamento).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['departamentos'])
        }
      )
    }
  }

}
