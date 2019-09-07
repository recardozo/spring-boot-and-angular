import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { API_URL } from '../app.constants';
import { Cliente } from '../shared/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  listClientes() {
    return this.http.get<Cliente[]>(`${API_URL}/clientes`)
  }

  deleteCliente(id) {
    return this.http.delete(`${API_URL}/clientes/${id}`);
  }

  getCliente(id) {
    return this.http.get<Cliente>(`${API_URL}/clientes/${id}`);
  }

  updateCliente(id, cliente) {
    return this.http.put(`${API_URL}/clientes/${id}`, cliente);
  }


  createCliente(cliente) {
    return this.http.post(`${API_URL}/clientes/`, cliente);
  }


}

