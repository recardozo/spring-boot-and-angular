import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Departamento } from '../shared/departamento.model';
import { API_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class DepartamentoService {

  constructor(private http: HttpClient) { }

  listDepartamentos(){
    return this.http.get<Departamento[]>(`${API_URL}/departamentos`)
  }

  deleteDepartamento(id){
    return this.http.delete(`${API_URL}/departamentos/${id}`)
  }

  getDepartamento(id){
    return this.http.get<Departamento>(`${API_URL}/departamentos/${id}`)
  }

  updateDepartamento(id,departamento){
    return this.http.put(`${API_URL}/departamentos/${id}`,departamento)
  }

  createDepartamento(departamento){
    return this.http.post(`${API_URL}/departamentos/`,departamento)
  }
}
