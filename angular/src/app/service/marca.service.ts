import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { API_URL } from '../app.constants';
import { Marca } from '../shared/marca.model';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {

  constructor(private http:HttpClient) { }


  listMarcas(){
    return this.http.get<Marca[]>(`${API_URL}/marcas`);
  }

  deleteMarca(id){
    return this.http.delete(`${API_URL}/marcas/${id}`);  
  }

 getMarca(id: any){
    return this.http.get<Marca>(`${API_URL}/marcas/${id}`);  
  }
  updateMarca(id,marca){
    return this.http.put(`${API_URL}/marcas/${id}`,marca);  
  }

  createMarca(marca){
    return this.http.post(`${API_URL}/marcas/`,marca);  
  }
}
