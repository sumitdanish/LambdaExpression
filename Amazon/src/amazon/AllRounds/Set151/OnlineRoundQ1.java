package amazon.AllRounds.Set151;

import amazon.AllRounds.BinaryTree;
import amazon.AllRounds.TreeNode;

public class OnlineRoundQ1 {

	/**
	 * @param args
	 */
	
	static TreeNode tail;
	static TreeNode head;
	static TreeNode pre;/*Variable for fixing the left pointer in the binary tree*/
	public static void main(String[] args) {
		try{
			OnlineRoundQ1 q1 = new OnlineRoundQ1();
			BinaryTree binaryTree  = new BinaryTree();
			TreeNode tree = null;
			tree = binaryTree.createBT(tree);
			TreeNode tr = q1.getDLL(tree);
			q1.printNext(tr);
//			q1.createLinkedList(tree);
//			q1.print();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	
	/*First method to create DLL from BinaryTree*/
	
	
	private void createLinkedList(TreeNode root){
		try{
			try{
				if(root == null){
					return;
				}
				createLinkedList(root.getLeft());
				if(head == null){
					head = root;
					tail = head;
				}else{
					root.setLeft(head);
					head.setRight(root);
				}
				head = root;
				createLinkedList(root.getRight());
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	private TreeNode print(){
		try{
			TreeNode tail1 = tail;
			while(tail1!=null){
				System.out.print(tail1.getData()+",");
				tail1 = tail1.getRight();
			}
			return tail1;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	/****************************************************************************/
	
	/*By fixing the left pointer of the binary tree*/
	
	
	private TreeNode getDLL(TreeNode tree){
		try{
			fixLeftPointer(tree);
			return getRightNode(tree);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void fixLeftPointer(TreeNode tree){
		if(tree != null){
			fixLeftPointer(tree.getLeft());
			tree.setLeft(pre);
			pre = tree;
			fixLeftPointer(tree.getRight());
		}
	}
	
	
	private TreeNode getRightNode(TreeNode root){
		try{
			TreeNode right = root;
			while(right != null && right.getRight() != null){
				right = right.getRight();
			}
			
			while(right != null && right.getLeft() != null){
				pre = right;
				right = right.getLeft();
				right.setRight(pre);
			}
			return right;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	
	private void printNext(TreeNode tree){
		try{
			if(tree == null){
				return;
			}
			System.out.print(tree.getData()+",");
			printNext(tree.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
