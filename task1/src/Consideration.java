public class Consideration {

	public static void cross(Agent agent, char[][] massive, int row, int column) {
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
		agent.computeOpinion(countA, countB);
	}

	public static void rim(Agent agent, char[][] massive, int row, int column) {
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
		agent.computeOpinion(countA, countB);
	}

	public static void fullGraph(Agent agent, char[][] massive, int row, int column) {
		int countA;
		int countB;
		int i = (int) (Math.random() * massive.length);
		int j = (int) (Math.random() * massive[0].length);
		while (i == row && j == column) {
			i = (int) (Math.random() * massive.length);
			j = (int) (Math.random() * massive[0].length);
		}
		// System.out.println(""+i+"\t"+j);
		if (massive[i][j] == 'a') {
			countA = 1;
			countB = 0;
		} else {
			countA = 0;
			countB = 1;
		}
		agent.computeOpinion(countA, countB);
	}
}
