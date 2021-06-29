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
public class MyMain {

    public static void main(String[] args) throws InterruptedException {
        AGMKruskal kr = new AGMKruskal();
        kr.kruskal();
        Janela des = new Janela();
        des.abrirJanela();
    }

}
