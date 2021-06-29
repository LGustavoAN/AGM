/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agm;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class DesenhaAGM extends JPanel {

    private Aresta[] saida;
    private double[][] matriz;
    private int pontos[] = new int[58];
    private AGMKruskal k = new AGMKruskal();

    public DesenhaAGM() {
        this.saida = Rota.getSaida();
        this.matriz = LeituraArquivo.getMatrizPontos();
        for (int i = 0; i < 58; i++) {
            pontos[i] = i;
        }
    }

    @Override

    public void paintComponent(Graphics graphs) {
        super.paintComponent(graphs);
        this.setBackground(Color.WHITE);

        graphs.setColor(Color.RED);
        for (int i = 0; i < matriz.length; i++) {
            graphs.fillOval((int) (matriz[pontos[i]][0] * 6 - 6), (int) (matriz[pontos[i]][1] * 6 - 6), 11, 11);
        }

        for (int k = 0; k < saida.length && saida[k] != null; k++) {
            graphs.setColor(Color.BLUE);
            graphs.drawLine((int) (matriz[saida[k].getU()][0] * 6), (int) (matriz[saida[k].getU()][1] * 6),
                    (int) (matriz[saida[k].getV()][0] * 6), (int) (matriz[saida[k].getV()][1] * 6));

        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        graphs.drawString("Custo: "+k.custo(), 100, 700);
    }

}