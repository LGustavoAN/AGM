/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agm;

import java.util.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2018.1.08.025
 */
public class AGMKruskal extends Observable implements Runnable {

    private double matrizDistancias[][] = new double[58][58];
    private int nArestas = (LeituraArquivo.getMatrizDistancias().length * LeituraArquivo.getMatrizDistancias().length) / 2 - LeituraArquivo.getMatrizDistancias().length;
    private Aresta saida[];

    public AGMKruskal() {
        this.saida = Rota.getSaida();
        this.matrizDistancias = LeituraArquivo.getMatrizDistancias();
    }

    public double custo() {
        double custo = 0;
        for (int i = 0; i < saida.length; i++) {
            custo = custo + Rota.getSaidaPos(i).getPeso();
        }
        return custo;
    }

    public void kruskal() throws InterruptedException {
        ArrayList<Aresta> arestas = new ArrayList();
        int vertices[] = new int[58];
        for (int i = 0; i < this.matrizDistancias.length; i++) {
            vertices[i] = i;
            for (int j = i + 1; j < this.matrizDistancias[i].length; j++) {
                Aresta aresta = new Aresta(i, j, matrizDistancias[i][j]);
                arestas.add(aresta);
            }

        }
        Collections.sort(arestas);
        UnionFindPC conjunto = new UnionFindPC(vertices);
        int s = 0;
        for (int c = 0; c < arestas.size(); c++) {
            if (!conjunto.teste(arestas.get(c).getU(), arestas.get(c).getV()) && arestas.get(c).getPeso() > 0) {
                conjunto.uniao(arestas.get(c).getU(), arestas.get(c).getV());
                saida[s] = new Aresta(arestas.get(c).getU(), arestas.get(c).getV(), arestas.get(c).getPeso());
                s++;
            }

        }
        for (int w = 0; w < saida.length; w++) {
            System.out.print(" " + saida[w].getPeso() + " " + saida[w].getU() + " " + saida[w].getV());
            System.out.println("");
        }

    }

    public void mudaEstado() throws InterruptedException {
        setChanged();
        notifyObservers();
        Thread.sleep(4);
    }

    @Override
    public void run() {

        try {
            ModificaGrafo x = new ModificaGrafo();
            this.kruskal();
            for (int i = 0; i < 3192; i++) {
                x.ExecutarOperacao(i);
                this.kruskal();
                mudaEstado();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(AGMKruskal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
