import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto } from '../shared/produto.model';
import { API_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {



  constructor(private http:HttpClient) { }


  listProdutos(){
    return this.http.get<Produto[]>(`${API_URL}/produtos`);
  }

  deleteProduto(id){
    return this.http.delete(`${API_URL}/produtos/${id}`);  
  }

 getProduto(id: any){
    return this.http.get<Produto>(`${API_URL}/produtos/${id}`);  
  }
  updateProduto(id,produto){
    return this.http.put(`${API_URL}/produtos/${id}`,produto);  
  }

  createProduto(produto){
    return this.http.post(`${API_URL}/produtos/`,produto);  
  }

}
