
public class Cross extends Agent {
	public Cross(boolean a, boolean st, boolean cf) {
		super(a, st, cf);
	}

	public Cross() {
		super();
	}
	
	@Override
	public String getMethod() {
		return "Cross";
	}
	@Override
	public void bypass(char[][] massive, int row, int column) {
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
		computeOpinion(countA, countB);
	}

}
