package Huffman_Coding_src;
import java.util.Map;
import static Huffman_Coding_src.EncodeDecode.encodeMessage;
import static Huffman_Coding_src.HuffmanCoding.buildHuffmanTree;


public class Main {
    public static void main(String[] args) {
        String message = "this is an example for huffman encoding";
        Map<Character, String> huffmanCodes = buildHuffmanTree(message);
        String encodedMessage = encodeMessage(message, huffmanCodes);

        System.out.println("Original Message: " + message);
        System.out.println("Encoded Message: " + encodedMessage);
        //decode is pending
    }
}