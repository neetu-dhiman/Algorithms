import java.util.*;
class HuffmanNode implements Comparable<HuffmanNode>{
	int freq;
	char ch;
	HuffmanNode left;
	HuffmanNode right;
	HuffmanNode(char c, int d){
		this.freq=d;
		this.ch=c;
		left=null; right=null;
	}
	public int compareTo(HuffmanNode node) {
		return this.freq - node.freq;
	}
}
class Huffman {
	int len;
	HuffmanNode root ;
	PriorityQueue<HuffmanNode> pQueue ;
	Huffman(int n) {
		this.root = null;
		this.len = n;
		this.pQueue = new PriorityQueue<HuffmanNode>(n);
	}
	void createMinHeap(char charArray[], int charfreq[]) {
		for(int i=0;i<charArray.length;i++) {
			HuffmanNode node = new HuffmanNode(charArray[i], charfreq[i]);
			pQueue.add(node);
		}
	}
	
	void createTree() {
		while(pQueue.size()>1) {
			HuffmanNode x = pQueue.peek(); pQueue.poll();
			HuffmanNode y = pQueue.peek(); pQueue.poll();
			HuffmanNode node = new HuffmanNode('#', x.freq + y.freq);
			node.left = x;
			node.right = y;
			pQueue.add(node);
			root = node;
		}
	}
	void printCode(HuffmanNode root, String str) {
		if (root.left == null && root.right == null && Character.isLetter(root.ch)) { 
            System.out.println(root.ch + ":" + str);
            return; 
        } 
        printCode(root.left, str + "0"); 
        printCode(root.right, str + "1"); 
	}
}
public class HuffmanDemo {
	public static void main(String []args) {
		int n = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 
		Huffman huff = new Huffman(n);
		huff.createMinHeap(charArray, charfreq);
		huff.createTree();
		huff.printCode("");
	}
}