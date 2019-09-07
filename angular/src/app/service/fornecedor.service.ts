import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../app.constants';
import { Fornecedor } from '../shared/fornecedor.model';

@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  constructor(private http: HttpClient) { }

  listFornecedores() {
    return this.http.get<Fornecedor[]>(`${API_URL}/fornecedores`)
  }

  deleteFornecedor(id) {
    return this.http.delete(`${API_URL}/fornecedores/${id}`);
  }

  getFornecedor(id) {
    return this.http.get<Fornecedor>(`${API_URL}/fornecedores/${id}`);
  }

  updateFornecedor(id, fornecedor) {
    return this.http.put(`${API_URL}/fornecedores/${id}`, fornecedor);
  }


  createFornecedor(fornecedor){
    return this.http.post(`${API_URL}/fornecedores/`,fornecedor);  
  }
}
