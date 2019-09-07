import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Funcionario } from '../shared/funcionario.model';
import { API_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class FuncionarioService {

  constructor(private http: HttpClient) { }

  listFuncionarios() {
    return this.http.get<Funcionario[]>(`${API_URL}/funcionarios`);
  }

  deleteFuncionario(id) {
    return this.http.delete(`${API_URL}/funcionarios/${id}`);
  }

  getFuncionario(id) {
    return this.http.get<Funcionario>(`${API_URL}/funcionarios/${id}`);  
  }

  updateFuncionario(id, funcionario) {
    return this.http.put(`${API_URL}/funcionarios/${id}`, funcionario);
  }

  createFuncionario(funcionario) {
    return this.http.post(`${API_URL}/funcionarios`, funcionario);
  }
}
