package amazon.AllRounds.Set151;

import amazon.AllRounds.BinaryTree;
import amazon.AllRounds.TreeNode;

public class F2F3Q1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			F2F3Q1 f2fq1 = new F2F3Q1();
			BinaryTree bt = new BinaryTree();
			TreeNode tree = null;
			tree = bt.createBT(tree);
			f2fq1.connectNext(tree);
			f2fq1.printNode(tree.getLeft().getRight().getLeft().getNext());
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	private void printNode(TreeNode tn){
		try{
			System.out.println(tn.getData());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	private void connectNext(TreeNode tree){
		try{
			if(tree == null){
				return;
			}
			if(tree!=null){
				if(tree.getRight()!=null){
					tree.getLeft().setNext(tree.getRight());
				}else if(tree.getLeft() != null){
					tree.getLeft().setNext(getNextNode(tree));
				}
			}
			if(tree.getRight() != null){
				tree.getRight().setNext(getNextNode(tree));
			}
			
			connectNext(tree.getLeft());
			connectNext(tree.getRight());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public TreeNode getNextNode(TreeNode np){
		try{
			if(np == null){
				return np;
			}
			TreeNode temp = np.getNext();
			while(temp != null){
				if(temp.getLeft() != null){
					return temp.getLeft();
				}
				if(temp.getRight() != null){
					return temp.getRight();
				}
				temp = temp.getNext();
			}
			return null;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
