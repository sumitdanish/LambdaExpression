package com.aorg.MyPractice.DS.DisjointDS;

public class DisjointDS {

	/**
	 * @param args
	 */
	static int[] parent;
	public static void main(String[] args) {
		try{
			DisjointDS ds = new DisjointDS();
			int[] a = new int[10];
			ds.makeSet(a);
//			ds.union(1,2);
//			ds.union(0,2);
//			ds.union(5,6);
			ds.unionBySize(1,2);
			ds.unionBySize(0,2);
			ds.unionBySize(5,6);
			int pa = ds.findByRank(0);
			System.out.println(pa);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public DisjointDS(){
		parent = new int[10];
	}
	
	public void makeSet(int[] a){
		try{
			for(int i = 0;i<a.length ; i++){
				parent[i] = i;
			}
			parent[0] = 2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int find(int x){
		try{
			if(x < 0 || x > parent.length){
				return Integer.MIN_VALUE;
			}
			if(parent[x] == x){
				return x;
			}
			return find(parent[x]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
	public void union(int root1,int root2){
		try{
			if(find(root1) == find(root2)){
				return;
			}
			/*Here parent of root1 is root2*/
			parent[root1] = root2;
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	/*Union By Size of the tree*/
	
	public void unionBySize(int root1,int root2){
		try{
			if(findByRank(root1) == findByRank(root2)){
				return;
			}
			if(parent[root1] == parent[root2]){
				parent[root1] = -1;
			}
			if(parent[root1] < parent[root2]){
				parent[root1] = root2;
				parent[root2]--;
			}else{
				parent[root2] = root1;
				parent[root1]--;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public int findByRank(int x){
		try{
			if(parent[x] == x){
				return parent[x];
			}
			return findByRank(parent[x]);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
}
