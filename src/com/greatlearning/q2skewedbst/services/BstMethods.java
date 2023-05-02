package com.greatlearning.q2skewedbst.services;

public class BstMethods {
	
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	
	// Method to convert the BST into right skewed tree
		public Node convertBstToRightSkewed(Node root) {
			if (root == null) {
				return root;
			}

			// Recursion for left subtree
			convertBstToRightSkewed(root.left);

			// Saving right child of 'root' node in a separate variable
			Node rightNode = root.right;

			// checking if the root node of the skewed tree is not defined
			if (headNode == null) {
				headNode = root;
				root.left = null;
				prevNode = root;
			} else {
				prevNode.right = root;
				root.left = null;
				prevNode = root;
			}

			// Recursion for right subtree
			convertBstToRightSkewed(rightNode);

			return headNode;
		}

		// Method to traverse the right skewed tree
		public void traverseRightSkewed(Node root) {
			if (root == null) {
				return;
			}
			System.out.print(root.val + " ");
			traverseRightSkewed(root.right);
		}

}
