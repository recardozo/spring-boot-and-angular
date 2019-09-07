import { Component, OnInit, Input, Output } from '@angular/core';
import { Produto } from '../shared/produto.model';
import { ProdutoService } from '../service/produto.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Marca } from '../shared/marca.model';

@Component({
  selector: 'app-list-produto',
  templateUrl: './list-produto.component.html',
  styleUrls: ['./list-produto.component.css']
})
export class ListProdutoComponent implements OnInit {

  @Output() marca: Marca;
  message: string;
  produtos: Produto[];

  constructor(private produtoService: ProdutoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {

    console.log('Marca ' + this.marca);
    this.refreshProdutos();
  }
  refreshProdutos() {
    this.produtoService.listProdutos().subscribe(
      response => {
        console.log(response);
        this.produtos = response;
      }
    )
  }

  deleteProduto(id: any) {
    this.produtoService.deleteProduto(id).subscribe(
      response => {
        console.log(response);
        this.message = `Produto ${id} has been deleted!`;
        this.refreshProdutos();
      }
    )
  }


  updateProduto(id: any) {
    console.log(`Produto ${id} has been updated!`);
    this.router.navigate(['produtos', id]);
  }

  addProduto() {
    this.router.navigate(['produtos', -1]);
  }

}
