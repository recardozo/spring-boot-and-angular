import { Component, OnInit } from '@angular/core';
import { MarcaService } from '../service/marca.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Marca } from '../shared/marca.model';
import { Fornecedor } from '../shared/fornecedor.model';
import { FornecedorService } from '../service/fornecedor.service';

@Component({
  selector: 'app-marca',
  templateUrl: './marca.component.html',
  styleUrls: ['./marca.component.css']
})

export class MarcaComponent implements OnInit {

  constructor(private fornecedorService:FornecedorService,private marcaService: MarcaService, private route: ActivatedRoute, private router: Router) { }

  id: number;
  fornecedor:Fornecedor;
  marca: Marca;
  fornecedores:Fornecedor[];

  
  ngOnInit() {

    this.listMarcasFornecedores();
    //this code brings the id from another page as parameter
    this.id = this.route.snapshot.params['id'];
    this.marca = new Marca(this.id, '', '',this.fornecedor);
    if (this.id != -1) {
      this.marcaService.getMarca(this.id).subscribe(
        response => this.marca = response
      );
    }
  }

  saveMarca() {
    if (this.id==-1) {
     this.marcaService.createMarca(this.marca).subscribe(
      data => {
        console.log(data),
          this.router.navigate(['marcas'])
      }
     )
    } else {
      this.marcaService.updateMarca(this.id, this.marca).subscribe(
        data => {
          console.log(data),
            this.router.navigate(['marcas'])
        }
      );
    }
   
  }

  listMarcasFornecedores(){
    this.fornecedorService.listFornecedores().subscribe(
      response=>{
        this.fornecedores=response;
        //console.log(response);
      }
    )
  }
}
