import java.util.Random;

class Agent {
	private boolean stubborn;
	private char opinion;
	private char method;

	public char getOpinion() {
		return opinion;
	}

	public void changeOpinion(char change) {
		if (!stubborn) {
			opinion = change;
		}

	}

	public char getMethod() {
		return method;
	}

	public String getSt() {
		if (stubborn) {
			return "Stubborn";
		} else {
			return "Not stubborn";
		}
	}

	/* no file */
	public Agent() {
		Random r = new Random();
		char[] opinions = { 'a', 'b' };
		char[] methods = { 'c', 'r', 'f' };
		opinion = opinions[r.nextInt(opinions.length)];
		stubborn = Math.random() < 0.5;
		method = methods[r.nextInt(methods.length)];
	}

	/* in file */
	public Agent(boolean a, boolean st) {
		Random r = new Random();
		char[] methods = { 'c', 'r', 'f' };
		method = methods[r.nextInt(methods.length)];
		if (a) {
			opinion = 'a';
		} else {
			opinion = 'b';
		}
		stubborn = st;
	}

	public String isConformist() {
		return null;
	}

	public void computeOpinion(boolean opinionShareA) {

	}

	public boolean cross(char[][] massive, int row, int column) {
		boolean opinionShareA = false;
		float[] rows = { ((float) row) + 1, ((float) row) - 1 };
		float[] columns = { ((float) column) + 1, ((float) column) - 1 };
		int countA = 0;
		int countB = 0;
		if (massive[row][column] == 'a') {
			countA++;
		} else {
			countB++;
		}
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] < 0 || rows[i] > (massive.length - 1)) {
				continue;
			}
			// System.out.println("" + rows[i] + "\t" + column);
			if (massive[(int) rows[i]][column] == 'a') {
				countA++;
			} else {
				countB++;
			}
		}
		for (int j = 0; j < columns.length; j++) {
			if (columns[j] < 0 || columns[j] > (massive[0].length - 1)) {
				continue;
			}
			// System.out.println("" + row + "\t" + columns[j]);
			if (massive[row][(int) columns[j]] == 'a') {

				countA++;
			} else {
				countB++;
			}
		}
		int W = countA + countB;
		Random r = new Random();
		int D = r.nextInt(W) + 1;
		// System.out.println(D);
		opinionShareA = D < countA;
		return opinionShareA;
	}

	public boolean rim(char[][] massive, int row, int column) {
		boolean opinionShareA = false;

		float[] rows = { ((float) row) - 1, (float) row, ((float) row) + 1 };
		float[] columns = { ((float) column) - 1, ((float) column), ((float) column) + 1 };
		int countA = 0;
		int countB = 0;
		if (massive[row][column] == 'a') {
			countA++;
		} else {
			countB++;
		}
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < columns.length; j++) {
				if ((int) rows[i] == row && (int) columns[j] == column) {
					continue;
				}
				if (rows[i] < 0 || columns[j] < 0 || rows[i] > (massive.length - 1)
						|| columns[j] > (massive[0].length - 1)) {
					continue;
				}

				if (massive[(int) rows[i]][(int) columns[j]] == 'a') {
					countA++;
				} else {
					countB++;
				}
			}
		}
		int W = countA + countB;
		Random r = new Random();
		int D = r.nextInt(W) + 1;
		// System.out.println(D);
		opinionShareA = D < countA;

		return opinionShareA;
	}

	public boolean fullGraph(char[][] massive, int row, int column) {
		boolean opinionShareA = false;
		int i = (int) (Math.random() * massive.length);
		int j = (int) (Math.random() * massive[0].length);
		while (i == row && j == column) {
			i = (int) (Math.random() * massive.length);
			j = (int) (Math.random() * massive[0].length);
		}
		// System.out.println(""+i+"\t"+j);
		if (massive[i][j] == 'a') {
			opinionShareA = true;
		} else {
			opinionShareA = false;
		}
		return opinionShareA;
	}

}