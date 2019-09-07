import { Component, OnInit, Input } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { API_URL } from '../app.constants';
import { Produto } from '../shared/produto.model';
import { ProdutoService } from '../service/produto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Marca } from '../shared/marca.model';
import { MarcaService } from '../service/marca.service';


@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.css']
})
export class ProdutoComponent implements OnInit {

  constructor(private produtoService: ProdutoService, private marcasService:MarcaService, private route: ActivatedRoute, private router: Router){}

    id: number;
    marca:Marca;
    produto: Produto;
    marcas:Marca[];
    ngOnInit() {
      this.listProdutosMarca();
      //this code brings the id from another page as parameter
      this.id = this.route.snapshot.params['id'];
     
     console.log(this.produto)
      this.produto = new Produto(this.id, '', '', '','', this.marca,'');
      if (this.id != -1) {
        this.produtoService.getProduto(this.id).subscribe(
          response => this.produto = response
        );
      }
    }

    listProdutosMarca(){
      this.marcasService.listMarcas().subscribe(
        response=>{
          this.marcas=response;
          //console.log(response);
        }
      )
    }

    saveProduto() {
      if (this.id==-1) {
       this.produtoService.createProduto(this.produto).subscribe(
        data => {
          console.log(data),
            this.router.navigate(['produtos'])
        }
       )
      } else {
        this.produtoService.updateProduto(this.id, this.produto).subscribe(
          data => {
            console.log(data),
              this.router.navigate(['produtos'])
          }
        );
      }
    }
}
