/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agm;

public class ModificaGrafo {

    private String matrizOp[][];
    private Aresta saida[];
    private double matrizDistancias[][];
    AGMKruskal k = new AGMKruskal();

    public ModificaGrafo() {
        this.matrizOp = LeituraArquivo.getMatrizOp();
        this.saida = Rota.getSaida();
        this.matrizDistancias = LeituraArquivo.getMatrizDistancias();
    }

    public void ExecutarOperacao(int atual) {
        int m1, m2;
        if (matrizOp[atual][0].equals("rm")) {
            m1 = Integer.parseInt(matrizOp[atual][1]);
            m2 = Integer.parseInt(matrizOp[atual][2]);
            matrizDistancias[m1][m2] = (matrizDistancias[m1][m2]) * -1;
        } else {
            m1 = Integer.parseInt(matrizOp[atual][1]);
            m2 = Integer.parseInt(matrizOp[atual][2]);
            if (matrizDistancias[m1][m2] < 0) {
                matrizDistancias[m1][m2] = (matrizDistancias[m1][m2]) * -1;
            }
        }

    }
}