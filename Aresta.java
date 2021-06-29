/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agm;

/**
 *
 * @author 2018.1.08.025
 */
public class Aresta implements Comparable<Aresta> {

    private int u;
    private int v;
    private double peso;

    public Aresta(int u, int v, double p) {
        this.u = u;
        this.v = v;
        this.peso = p;
    }

    public void setU(int u) {
        this.u = u;
    }

    public void setV(int v) {
        this.v = v;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public int compareTo(Aresta a) {
        if (this.peso < a.peso) {
            return -1;
        } else if (this.peso == a.peso) {
            return 0;
        } else {
            return 1;
        }
    }

}
