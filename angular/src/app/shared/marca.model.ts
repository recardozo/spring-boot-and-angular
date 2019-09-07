import { Fornecedor } from './fornecedor.model';

export class Marca {

    constructor(
      public id:number,
      public nome: string,
      public descricao: string,
      public fornecedor:Fornecedor
    ) {
  
    }
  }