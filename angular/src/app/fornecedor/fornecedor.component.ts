import { Component, OnInit } from '@angular/core';
import { FornecedorService } from '../service/fornecedor.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Fornecedor } from '../shared/fornecedor.model';

@Component({
  selector: 'app-fornecedor',
  templateUrl: './fornecedor.component.html',
  styleUrls: ['./fornecedor.component.css']
})
export class FornecedorComponent implements OnInit {

  id:number;
  fornecedor:Fornecedor;
  
  constructor(private fornecedorService:FornecedorService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.id=this.route.snapshot.params['id'];
    this.fornecedor= new Fornecedor(this.id,'','','','');
    if(this.id!=-1){
      this.fornecedorService.getFornecedor(this.id).subscribe(
        response=>this.fornecedor=response
      );
    }
  }

  saveFornecedor(){
   if(this.id==-1){
    this.fornecedorService.createFornecedor(this.fornecedor).subscribe(
      data=>{
       console.log(data);
       this.router.navigate(['fornecedores'])
      }
     )
   }else{
     this.fornecedorService.updateFornecedor(this.id,this.fornecedor).subscribe(
       data=>{
         console.log(data);
         this.router.navigate(['fornecedores']);
       }
     )
   }
  }

}
