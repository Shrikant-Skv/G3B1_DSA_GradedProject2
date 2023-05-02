package com.greatlearning.q2skewedbst.services;

//Class of the node
public class Node {
	public int val;
	public Node left;
	public Node right;

	public Node(int data) {
		val = data;
		left = right = null;
	}
}