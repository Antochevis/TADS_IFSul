package br.edu.ifsul.ed.arvores;

public class BinNo {
    int valor;
    BinNo esq;
    BinNo dir;
    int nivel;

    public BinNo(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.nivel = -1;
    }
}
