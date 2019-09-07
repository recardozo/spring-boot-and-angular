import { BrowserModule } from '@angular/platform-browser';
import {LOCALE_ID, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ListMarcaComponent } from './list-marca/list-marca.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { MarcaComponent } from './marca/marca.component';
import { HttpInterceptorService } from './http/http-interceptor.service';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProdutoComponent } from './produto/produto.component';
import { ListProdutoComponent } from './list-produto/list-produto.component';
import { CommonModule,registerLocaleData } from '@angular/common';
import localeBrExtra from '@angular/common/locales/extra/fr';
import localeBr from '@angular/common/locales/pt';
import { ListFornecedorComponent } from './list-fornecedor/list-fornecedor.component';
import { FornecedorComponent } from './fornecedor/fornecedor.component';
import { ListClienteComponent } from './list-cliente/list-cliente.component';
import { ClienteComponent } from './cliente/cliente.component';
import { DepartamentoComponent } from './departamento/departamento.component';
import { ListDepartamentoComponent } from './list-departamento/list-departamento.component';
import { FuncionarioComponent } from './funcionario/funcionario.component';
import { ListFuncionarioComponent } from './list-funcionario/list-funcionario.component';
import { BasicAuthenticationService } from './service/basic-authentication.service';

registerLocaleData(localeBr, 'pt', localeBrExtra);
@NgModule({
  declarations: [
    AppComponent,
    ListMarcaComponent,
    MarcaComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    ProdutoComponent,
    ListProdutoComponent,
    ListFornecedorComponent,
    FornecedorComponent,
    ListClienteComponent,
    ClienteComponent,
    DepartamentoComponent,
    ListDepartamentoComponent,
    FuncionarioComponent,
    ListFuncionarioComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule
  ],
  providers: [
    {provide:HTTP_INTERCEPTORS, useClass:HttpInterceptorService, multi:true},
    BasicAuthenticationService
    
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
