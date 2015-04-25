package com.aorg.MyPractice.DS.Graph;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakeAndLadderProblem {

	public static void main(String[] args) {
		try{
			SnakeAndLadderProblem sn = new SnakeAndLadderProblem();
			int row = 29;
			int[] moves = new int[row];
			for(int i = 0;i<row;i++){
				moves[i] = -1;
			}
			int minDis = 0;
			Scanner sc = new Scanner(new File("snake.txt"));
			while(sc.hasNext()){
				String[] st = sc.next().split(",");
				int ver = Integer.parseInt(st[0]);
				int dest = Integer.parseInt(st[1]);
				moves[ver] = dest;
			}
			minDis = sn.snakAndLadder(row, moves);
			System.out.println(minDis);
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	
	public int snakAndLadder(int row,int[] move){
		try{
			boolean[] visited = new boolean[row];
			Eadge eadge = new Eadge(0,0);
			Queue<Eadge>  que = new LinkedList<Eadge>();
			que.add(eadge);
			Eadge e = null;
			visited[0] = true;
			while(!que.isEmpty()){
				e = que.poll();
				int v = e.getV();
				if(v == row-1){
					break;
				}
				for(int j = (v+1);j<=(v+6) &&j<row;j++){
					if(!visited[j]){
						visited[j] = true;
						Eadge e1 = new Eadge(0,0);
						e1.setDest(e.getDest()+1);
						if(move[j]!=-1){
							e1.setV(move[j]);
						}else{
							e1.setV(j);
						}
						que.add(e1);
					}
				}
			}
			return e.getDest();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return -1;
	}
	
	
}

class Eadge
{
	private int v;
	private int dest;
	public Eadge(int v,int dest){
		this.dest = dest;
		this.v = v;
	}
	
	public void setDest(int dest){
		this.dest = dest;
	}
	public void setV(int v){
		this.v = v;
	}
	public int getDest(){
		return dest;
	}
	public int getV(){
		return v;
	}
}