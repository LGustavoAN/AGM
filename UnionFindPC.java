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
public class UnionFindPC {

    private Node[] nodes;

    public UnionFindPC(int vetor[]) {
        this.nodes = new Node[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            this.nodes[i] = new Node(vetor[i], null);
            this.nodes[i].setFather(this.nodes[i]);
        }
    }

    public void uniao(int x, int y) {
        Node aux = getRaiz(x);
        Node aux2 = getRaiz(y);
        aux.setFather(aux2);
        nodes[x].setFather(aux2);
        nodes[y].setFather(aux2);

    }

    public Node getRaiz(int x) {
        Node aux = nodes[x];
        while (aux.getFather() != aux) {
            aux = aux.getFather();
        }
        return aux;
    }

    public boolean teste(int x, int y) {
        return getRaiz(x) == getRaiz(y);
    }

}
