package Huffman_Coding_src;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
    //map to store encoded characters
    public static Map<Character, String> buildHuffmanTree(String str){
        //construct frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c: str.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
        }

        // adding priiority queue
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(char c: freqMap.keySet()){
            pq.add(new Node(c, freqMap.get(c)));
        }

        //combine two nodes untill you only have one node in queue
        while(pq.size()>1){
            Node left = pq.remove();
            Node right = pq.remove();
            Node parent = new Node('\0',left.freq+right.freq);
            parent.left=left;
            parent.right=right;
            pq.add(parent);
        }
        Node root = pq.poll();
        Map<Character,String> huffmanMap = new HashMap<>();
        generateHuffManCoding(root,"",huffmanMap);
        return huffmanMap;
    }
    private static void generateHuffManCoding(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.symbol, code);
        }
        //add 0 when move left
        generateHuffManCoding(node.left, code + "0", huffmanCodes);
        //add 1 when moving right
        generateHuffManCoding(node.right, code + "1", huffmanCodes);
    }
}
