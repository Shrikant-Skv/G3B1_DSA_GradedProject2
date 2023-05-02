package com.greatlearning.q2skewedbst.driver;
import com.greatlearning.q2skewedbst.services.*;

public class Main {

	private static Node node;

	// Driver Code
	public static void main(String[] args) {

		Main tree = new Main();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		BstMethods obj = new BstMethods();
		
		Node rightSkewedNode = obj.convertBstToRightSkewed(node);
		obj.traverseRightSkewed(rightSkewedNode);
	}
}
