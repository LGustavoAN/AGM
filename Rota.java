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
public class Rota {

    private static Aresta[] saida;

    private Rota() {
    }

    public static Aresta[] getSaida() {
        if (saida == null) {
            saida = new Aresta[57];
        }
        return saida;
    }

    public static Aresta getSaidaPos(int i) {
        return saida[i];
    }

}
