package com.aorg.MyPractice.DS.LinkList;

import amazon.AllRounds.BinaryTree;
import amazon.AllRounds.TreeNode;

public class FlattenABinaryTreeToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FlattenABinaryTreeToLinkedList fl = new FlattenABinaryTreeToLinkedList();
			BinaryTree bt = new BinaryTree();
			TreeNode tr = null;
			tr = bt.createBT(tr);
			TreeNode tr1 = fl.createSinglyList(tr);
			fl.printFlatten(tr);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	private TreeNode createSinglyList(TreeNode bt){
		try{
			if(bt == null){
				return bt;
			}
			TreeNode tn = bt.getRight();
			if(bt.getLeft() != null){
				TreeNode left = bt.getLeft();
				bt.setRight(left);
				bt.setLeft(null);
				bt = createSinglyList(bt.getRight());
			}
			if(tn != null){
				bt.setRight(tn);
				bt = createSinglyList(bt.getRight());
			}
			return bt;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void printFlatten(TreeNode tn){
		try{
			if(tn == null){
				return;
			}
			System.out.print(tn.getData()+",");
			printFlatten(tn.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
