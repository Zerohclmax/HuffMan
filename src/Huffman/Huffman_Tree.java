package Huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Huffman_Tree {
    public static void main(String[] args) {
        int[] arr={13,7,8,3,29,6,1};
        Node root=createHaffman_Tree(arr);
        preOrder(root);
    }
    public static Node createHaffman_Tree(int[] arr){
        List<Node> nodes= new ArrayList<Node>();
        for (int i:arr){
            nodes.add(new Node(i));
        }
        while(nodes.size()>1){
            Collections.sort(nodes);
            Node Rightnode=nodes.get(1);
            Node Leftnode = nodes.get(0);
            Node node1 = new Node(Rightnode.valuable+Leftnode.valuable);
            node1.left=Leftnode;
            node1.right=Rightnode;
            nodes.remove(Rightnode);
            nodes.remove(Leftnode);
            nodes.add(node1);
        }
        return nodes.get(0);
    }
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrde();
        }else {
            System.out.println("此数组为空");
        }
    }
}
class Node implements Comparable<Node>{
   public int valuable;
    public Node left;
    public Node right;
    public Node(int valuable){
        this.valuable=valuable;
    }
    public void preOrde(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrde();
        }
        if (this.right!=null){
            this.right.preOrde();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "valuable=" + valuable +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.valuable - o.valuable;
    }
}
