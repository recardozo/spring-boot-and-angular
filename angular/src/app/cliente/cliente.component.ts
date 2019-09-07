import { Component, OnInit } from '@angular/core';
import { Cliente } from '../shared/cliente.model';
import { ClienteService } from '../service/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  id:number;
  cliente:Cliente;
  
  constructor(private clienteService:ClienteService,private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.id=this.route.snapshot.params['id'];
    this.cliente= new Cliente(this.id,'','','','');
    if(this.id!=-1){
      this.clienteService.getCliente(this.id).subscribe(
        response=>this.cliente=response
      );
    }
  }

  saveCliente(){
    if(this.id==-1){
     this.clienteService.createCliente(this.cliente).subscribe(
       data=>{
        console.log(data);
        this.router.navigate(['clientes'])
       }
      )
    }else{
      this.clienteService.updateCliente(this.id,this.cliente).subscribe(
        data=>{
          console.log(data);
          this.router.navigate(['clientes']);
        }
      )
    }
   }

}
