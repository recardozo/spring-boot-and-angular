import { Component, OnInit } from '@angular/core';
import { Fornecedor } from '../shared/fornecedor.model';
import { ActivatedRoute, Router } from '@angular/router';
import { FornecedorService } from '../service/fornecedor.service';

@Component({
  selector: 'app-list-fornecedor',
  templateUrl: './list-fornecedor.component.html',
  styleUrls: ['./list-fornecedor.component.css']
})
export class ListFornecedorComponent implements OnInit {

  message: string;
  fornecedores: Fornecedor[];


  constructor(private fornecedorService: FornecedorService, private router: Router) { }

  ngOnInit() {
    this.refreshFornecedores();
  }
  refreshFornecedores() {
    this.fornecedorService.listFornecedores().subscribe(
      response => {
        this.fornecedores = response;
        console.log(this.fornecedores)
      }
    );
  }

  deleteFornecedor(id) {
    this.fornecedorService.deleteFornecedor(id).subscribe(
      response => {
        console.log(response);
        this.message = `Fornecedor ${id} has been deleted!`;
        this.refreshFornecedores();
      }
    )
  }

  updateFornecedor(id) {
    console.log(`Fornecedor ${id} has been updated!`);
    this.router.navigate(['fornecedores', id]);
  }

  addFornecedor() {
    this.router.navigate(['fornecedores', -1]);
  }

}
