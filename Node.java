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
public class Node {

    private int key;
    private Node father;

    public Node(int k, Node f) {
        this.key = k;
        this.father = f;

    }

    public int getKey() {
        return key;
    }

    public Node getFather() {
        return father;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setFather(Node father) {
        this.father = father;
    }
    
    

}
