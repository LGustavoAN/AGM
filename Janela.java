/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agm;

import javax.swing.*;

import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2018.1.08.025
 */
public class Janela extends JPanel implements Observer, ActionListener {

    private double matrizPontos[][];
    private Aresta saida[];
    private JFrame janela = new JFrame();
    JButton botao = new JButton();
    private AGMKruskal ob = new AGMKruskal();

    public Janela() {
        this.matrizPontos = LeituraArquivo.getMatrizPontos();
        this.saida = Rota.getSaida();
    }

    public void abrirJanela() {
        janela.setExtendedState(MAXIMIZED_BOTH);
        janela.setTitle("@");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botao.setText("Play");
        botao.setBounds(100, 800, 200, 50);
        botao.addActionListener(this);
        DesenhaAGM grafo = new DesenhaAGM();
        ob.addObserver(this);
        janela.add(botao);
        janela.add(grafo);
        janela.setVisible(true);

    }

    @Override
    public void update(Observable o, Object arg) {
        janela.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Thread th = new Thread(this.ob);
        th.start();
        botao.setEnabled(false);
    }

}