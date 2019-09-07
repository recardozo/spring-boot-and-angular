import { Departamento } from './departamento.model';

export class Funcionario{
    constructor(
        public id:number,
        public nome: string,
        public rg:string,
        public cpf:string,
        public salario:string,
        public departamento:Departamento
    ){}
}