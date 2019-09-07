import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../service/cliente.service';
import { Router } from '@angular/router';
import { Cliente } from '../shared/cliente.model';

@Component({
  selector: 'app-list-cliente',
  templateUrl: './list-cliente.component.html',
  styleUrls: ['./list-cliente.component.css']
})
export class ListClienteComponent implements OnInit {
  message: string;

  constructor(private clienteService: ClienteService, private router: Router) { }
  clientes: Cliente[];

  ngOnInit() {
    this.refreshClientes();
  }
  refreshClientes() {
    this.clienteService.listClientes().subscribe(
      response => {
        this.clientes = response;
        console.log(this.clientes);
      }
    );
  }

  deleteCliente(id) {
    this.clienteService.deleteCliente(id).subscribe(
      response => {
        console.log(response);
        this.message = `Cliente ${id} has been deleted!`;
        this.refreshClientes();
      }
    )
  }

  updateCliente(id) {
    console.log(`Cliente ${id} has been updated!`);
    this.router.navigate(['clientes', id]);
  }

  addCliente() {
    this.router.navigate(['clientes', -1]);
  }

}
