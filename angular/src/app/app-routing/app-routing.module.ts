import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router'
import { ListMarcaComponent } from '../list-marca/list-marca.component';
import { MarcaComponent } from '../marca/marca.component';
import { LoginComponent } from '../login/login.component';
import { RouteGuardService } from '../service/route-guard.service';
import { ProdutoComponent } from '../produto/produto.component';
import { ListProdutoComponent } from '../list-produto/list-produto.component';
import { ListFornecedorComponent } from '../list-fornecedor/list-fornecedor.component';
import { FornecedorComponent } from '../fornecedor/fornecedor.component';
import { ClienteComponent } from '../cliente/cliente.component';
import { ListClienteComponent } from '../list-cliente/list-cliente.component';
import { ListDepartamentoComponent } from '../list-departamento/list-departamento.component';
import { DepartamentoComponent } from '../departamento/departamento.component';
import { FuncionarioComponent } from '../funcionario/funcionario.component';
import { ListFuncionarioComponent } from '../list-funcionario/list-funcionario.component';


const routes: Routes = [
  { path: 'marcas', component: ListMarcaComponent, canActivate: [RouteGuardService] },
  { path: 'marcas/:id', component: MarcaComponent, canActivate: [RouteGuardService] },
  { path: 'produtos', component: ListProdutoComponent, canActivate: [RouteGuardService] },
  { path: 'produtos/:id', component: ProdutoComponent, canActivate: [RouteGuardService] },
  { path: 'fornecedores', component: ListFornecedorComponent, canActivate: [RouteGuardService] },
  { path: 'fornecedores/:id', component: FornecedorComponent, canActivate: [RouteGuardService] },
  { path: 'clientes', component: ListClienteComponent, canActivate: [RouteGuardService] },
  { path: 'clientes/:id', component: ClienteComponent, canActivate: [RouteGuardService] },
  { path: 'departamentos', component: ListDepartamentoComponent, canActivate: [RouteGuardService] },
  { path: 'departamentos/:id', component: DepartamentoComponent, canActivate: [RouteGuardService] },
  {path:'funcionarios',component:ListFuncionarioComponent,canActivate: [RouteGuardService] },
  {path:'funcionarios/:id',component:FuncionarioComponent,canActivate: [RouteGuardService] },
   { path: 'login', component: LoginComponent }


]
@NgModule({
  declarations: [],
  imports: [
    CommonModule, RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
