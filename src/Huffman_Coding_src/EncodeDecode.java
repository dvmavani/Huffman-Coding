package Huffman_Coding_src;

import java.util.Map;

public class EncodeDecode {
    public static String encodeMessage(String message, Map<Character, String> huffmanCodes) {
        StringBuilder encodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            encodedMessage.append(huffmanCodes.get(c));
        }
        return encodedMessage.toString();
    }
    public static String decodeMessage(String encodedMessage, Node root) {
        StringBuilder decodedMessage = new StringBuilder();
        Node current = root;
        for (char c : encodedMessage.toCharArray()) {
            if (c == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                decodedMessage.append(current.symbol);
                current = root;
            }
        }
        return decodedMessage.toString();
    }
}
