package ristinolla;

import java.util.Arrays;

public class Ristinolla {

	private String vuoro;
	private final String[][] ristinolla;

	public Ristinolla() {
		this.vuoro = "X";
		this.ristinolla = new String[][]{
				{" ", " ", " "},
				{" ", " ", " "},
				{" ", " ", " "}
		};
	}

	public String vuoro() {
		return this.vuoro;
	}

	public String status(int x, int y) {
		if (x < 0 || x > 2 || y < 0 || y > 2) {
			return "";
		}

		return this.ristinolla[x][y];
	}

	public void setMark(int x, int y) {
		if (x < 0 || x > 2 || y < 0 || y > 2) {
			return;
		}

		if (!this.ristinolla[x][y].equals(" ")) {
			return;
		}

		if (loppu()) {
			return;
		}

		this.ristinolla[x][y] = this.vuoro;

		if (this.vuoro.equals("X")) {
			this.vuoro = "O";
		} else {
			this.vuoro = "X";
		}

	}

	public boolean loppu() {
		int[][] samat = {
				{0, 1, 2},
				{3, 4, 5},
				{6, 7, 8},
				{0, 3, 6},
				{1, 4, 7},
				{2, 5, 8},
				{0, 4, 8},
				{2, 5, 6}
		};

		for (int[] vals : samat) {
			if (tablesMatch(vals)) {
				return true;
			}
		}

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (status(x, y).trim().isEmpty()) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean tablesMatch(int[] taulukko) {
		String[] arvot = {getArvo(taulukko[0]), getArvo(taulukko[1]), getArvo(taulukko[2])};
		Arrays.sort(arvot);
		return arvot[0].equals(arvot[1])
				&& arvot[0].equals(arvot[2])
				&& !arvot[0].trim().isEmpty();
	}

	private String getArvo(int pos) {
		int x = pos % 3;
		int y = pos / 3;

		return this.ristinolla[x][y];
	}
}
