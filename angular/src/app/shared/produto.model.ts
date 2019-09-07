import { Marca } from './marca.model';

export class Produto {
    constructor(
        public id: number,
        public nome: string,
        public descricao: string,
        public setor: string,
        public preco: string,
        public marca: Marca,
        public colecao: {}
    ) {

    }
}