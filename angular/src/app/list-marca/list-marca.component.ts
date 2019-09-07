import { Component, OnInit } from '@angular/core';
import { MarcaService } from '../service/marca.service';
import { Router } from '@angular/router';
import { Marca } from '../shared/marca.model';


// export class Marca {

//   constructor(
//     public id:number,
//     public nome: string,
//     public descricao: string,
//     public colecao: {}
//   ) {

//   }
// }

@Component({
  selector: 'app-list-marca',
  templateUrl: './list-marca.component.html',
  styleUrls: ['./list-marca.component.css']
})
export class ListMarcaComponent implements OnInit {

  message:string;
  marcas: Marca[];
  constructor(private marcaService:MarcaService,private router:Router) { }

  ngOnInit() {
    this.refreshMarcas();
  }

  refreshMarcas(){
    this.marcaService.listMarcas().subscribe(
      response=>{
        console.log(response);
        this.marcas=response;
      }
    );
  }
  deleteMarca(id: any){
    this.marcaService.deleteMarca(id).subscribe(
      response=>{
        console.log(response);
        this.message=`Marca ${id} has been deleted!`;
        this.refreshMarcas();
      }
    )
  }

  updateMarca(id: any){
   console.log(`Marca ${id} has been updated!`);
   this.router.navigate(['marcas',id]);
  }

  addMarca(){
    this.router.navigate(['marcas',-1]);
  }

}
