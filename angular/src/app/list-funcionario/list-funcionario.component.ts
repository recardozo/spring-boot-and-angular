import { Component, OnInit, Output } from '@angular/core';
import { Funcionario } from '../shared/funcionario.model';
import { Router, ActivatedRoute } from '@angular/router';
import { FuncionarioService } from '../service/funcionario.service';
import { Departamento } from '../shared/departamento.model';

@Component({
  selector: 'app-list-funcionario',
  templateUrl: './list-funcionario.component.html',
  styleUrls: ['./list-funcionario.component.css']
})
export class ListFuncionarioComponent implements OnInit {
  // @Output() departamento:Departamento
  message: string;
  funcionarios:Funcionario[];
  
  constructor(private funcionarioService:FuncionarioService, private router: Router) { }

  ngOnInit() {
    this.refreshFuncionarios();
  }

  refreshFuncionarios(){
    this.funcionarioService.listFuncionarios().subscribe(
      response=>{
        this.funcionarios=response;
        console.log(this.funcionarios);
      }
    )
  }

  deleteFuncionario(id: any) {
    this.funcionarioService.deleteFuncionario(id).subscribe(
      response => {
        console.log(response);
        this.message = `Funcionario ${id} has been deleted!`;
        this.refreshFuncionarios();
      }
    )
  }
  updateFuncionario(id: any) {
    console.log(`Funcionario ${id} has been updated!`);
    this.router.navigate(['funcionarios', id]);
  }

  addFuncionario() {
    this.router.navigate(['funcionarios', -1]);
  }
}
