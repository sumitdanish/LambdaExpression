package com.aorg.MyPractice.DS.Graph;
/*
 *Apr 27, 2015
 *SUMMIT
 *5:21:49 PM
 *2015
 *
 */
public class DijasktraAlgo1 {

	
	static int[] dist;
	static boolean[] visited;
	public static void main(String[] args) {
		try{
			int[][] adJacencyMatt = { // 0 1 2 3 4 4 6 7 8
									   { 0, 4, 0, 0, 0, 0, 0, 8, 0 },	// each cell value represent
																		// the weight between the
																		// vertex
									   { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
									   { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
									   { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
									   { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
									   { 0, 0, 4, 0, 10, 0, 2, 0, 0 },
									   { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
									   { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
									   { 0, 0, 2, 0, 0, 0, 6, 7, 0}
									};
			
			int vertex = 9;
			DijasktraAlgo1 dij = new DijasktraAlgo1(vertex);
			dij.sortestPath(adJacencyMatt, 0, vertex);
			for(int i = 0;i<vertex;i++){
				System.out.println(dist[i]+",");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}
	
	public DijasktraAlgo1(int vertex){
		dist = new int[vertex];
		visited = new boolean[vertex];
		for(int i = 0;i<vertex;i++){
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
	}
	public int getVertex(int[][] mat,int vertex){
		try{
			int min_index = 0;
			int max = Integer.MAX_VALUE;
			for(int i = 0;i<vertex;i++){
				if(!visited[i]&&dist[i] <=max){
					max = dist[i];
					min_index = i;
				}
			}
			return min_index;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	public void sortestPath(int[][] mat,int src,int vertex){
		try{
			
			dist[0] = 0;
			for(int i = 0;i<vertex-1;i++){
				int u = getVertex(mat, vertex);
				visited[u] = true;
				for(int j = 0;j<vertex;j++){
					if(!visited[j] && mat[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[j] >= dist[u]+mat[u][j]){
						dist[j] = dist[u]+mat[u][j];
					}
				}
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
