package trees;

import java.util.HashMap;

public class HuffmanTree {
    private int weight;
    private Node<Character> root;

    public static HuffmanTree fromCharFrequencies(HashMap<Character, Integer> freqs) {
        return null;
    }

    public HuffmanTree(char ch, int weight) {
        this.weight = weight;
        root = new Node<Character>(ch);
    }

    public HuffmanTree(HuffmanTree left, HuffmanTree right) {
        weight = left.weight + right.weight;
        root = new Node<Character>(null, null, left.root, right.root);
    }

    // create a map that contains the codes for every character in the tree.
    public HashMap<Character, String> generateCodes() {
        HashMap<Character, String> codes = new HashMap<>();
        StringBuffer prefix = new StringBuffer();
        generateCodes(root, prefix, codes);
        return codes;
    }

    private void generateCodes(Node<Character> node, StringBuffer prefix, HashMap<Character, String> codes) {
        if (node.left == null && node.right == null) {
            codes.put(node.data, prefix.toString());
            return;
        }

        if (node.left != null) {
            prefix.append('0');
            generateCodes(node.left, prefix, codes);
            prefix.deleteCharAt(prefix.length()-1);
        }

        if (node.right != null) {
            prefix.append('1');
            generateCodes(node.right, prefix, codes);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
}
