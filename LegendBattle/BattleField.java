package LegendBattle;

import java.util.List;
import java.util.ArrayList;

public class BattleField {
	private int[][] map;
	private int n;
	private int m;
	private List<Hero> heros = new ArrayList<Hero>();
		
	public BattleField() {
		
	}
	
	public BattleField(int n, int m) {
		this.n = n;
		this.m = m;
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < m; j++) {
				map[i][j] = 0;
			}
	}
	
	public void printField() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
