package Huffman_Coding_src;

public class Node implements Comparable<Node>{
    char symbol;
    int freq;
    Node left;
    Node right;
    public Node(char c, int f){
        this.symbol=c;
        this.freq=f;
        this.left=null;
        this.right=null;
    }
    @Override
    public int compareTo(Node other){
        return this.freq-other.freq;
    }
}
