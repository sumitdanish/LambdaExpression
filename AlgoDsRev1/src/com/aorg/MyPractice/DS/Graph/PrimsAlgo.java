package com.aorg.MyPractice.DS.Graph;

public class PrimsAlgo {
	/*
	 *Apr 28, 2015
	 *SUMMIT
	 *7:17:09 PM
	 *2015
	 *					
	 *					/* Let us create the following graph
					          2    3
					      (0)--(1)--(2)
					       |   / \   |
					      6| 8/   \5 |7
					       | /     \ |
					      (3)-------(4)
					            9         
	 *
	 */
	static int[] dist;
	static boolean[] visited;
	static boolean[] mst;
	static int[] parent;
	public static void main(String[] args) {
		try{
			int[][] adJacencyMatt = {
										{0, 2, 0, 6, 0},
					                    {2, 0, 3, 8, 5},
					                    {0, 3, 0, 0, 7},
					                    {6, 8, 0, 0, 9},
					                    {0, 5, 7, 9, 0},
                   					};

			int vertex = 5;
			new PrimsAlgo(vertex).mst(adJacencyMatt, vertex);
			for(int j = 0;j<vertex;j++){
				System.out.println(j+" > "+parent[j]+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public PrimsAlgo(int vertex){
		mst = new boolean[vertex];
		dist = new int[vertex];
		visited = new boolean[vertex];
		parent = new int[vertex];
		for(int j = 0;j<vertex;j++){
			dist[j] = Integer.MAX_VALUE;
		}
	}
	
	public int getMInDistance(int vertex,int[][] mat){
		try{
			int minIndex = 0;
			int max = Integer.MAX_VALUE;
			for(int i = 0;i<vertex;i++){
				if(!mst[i] && dist[i] < max){
					max = dist[i];
					minIndex = i;
				}
			}
			return minIndex;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public void mst(int[][] mat,int vertex){
		try{
			dist[0] = 0;
			mst[0] = true;
			parent[0] = -1;
			for(int j = 0;j<vertex-1;j++){
				int u = getMInDistance(vertex, mat);
				mst[u] = true;
				for(int i = 0;i<vertex;i++){
					if(!mst[i] && mat[u][i] != 0 && dist[i] != Integer.MAX_VALUE && dist[i] > mat[u][i]){
						parent[i] = u;
						dist[i] = mat[u][i];
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
