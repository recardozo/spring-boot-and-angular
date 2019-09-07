import { Component, OnInit } from '@angular/core';
import { FuncionarioService } from '../service/funcionario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Funcionario } from '../shared/funcionario.model';
import { Departamento } from '../shared/departamento.model';
import { DepartamentoService } from '../service/departamento.service';

@Component({
  selector: 'app-funcionario',
  templateUrl: './funcionario.component.html',
  styleUrls: ['./funcionario.component.css']
})
export class FuncionarioComponent implements OnInit {

  id: number;
  funcionario: Funcionario;
  departamento: Departamento;
  departamentos: Departamento[];
  constructor(private departamentoService: DepartamentoService, private funcionarioService: FuncionarioService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.listFuncionarioDepartamento();
    this.id = this.route.snapshot.params['id'];
    this.funcionario = new Funcionario(this.id, '', '', '','', this.departamento)
    if (this.id != -1) {
      this.funcionarioService.getFuncionario(this.id).subscribe(
        response => this.funcionario = response
        
      );
    }
  }

  listFuncionarioDepartamento(){
    this.departamentoService.listDepartamentos().subscribe(
      response=>{
        this.departamentos=response;
        //console.log(response);
      }
    )
  }

  saveFuncionario() {
    if (this.id==-1) {
     this.funcionarioService.createFuncionario(this.funcionario).subscribe(
      data => {
        console.log(data),
          this.router.navigate(['funcionarios'])
      }
     )
    } else {
      this.funcionarioService.updateFuncionario(this.id, this.funcionario).subscribe(
        data => {
          console.log(data),
            this.router.navigate(['funcionarios'])
        }
      );
    }
  }

}
