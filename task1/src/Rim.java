
public class Rim extends Agent {
	public Rim(boolean a, boolean st, boolean cf) {
		super(a, st, cf);
	}

	public Rim() {
		super();
	}
	
	@Override
	public String getMethod() {
		return "Rim";
	}

	@Override
	public void bypass(char[][] opinionField, int row, int column) {
		float[] rows = { ((float) row) - 1, (float) row, ((float) row) + 1 };
		float[] columns = { ((float) column) - 1, ((float) column), ((float) column) + 1 };
		int countA = 0;
		int countB = 0;
		if (opinionField[row][column] == 'a') {
			countA++;
		} else {
			countB++;
		}
		for (int i = 0; i < rows.length; i++) {
			for (int j = 0; j < columns.length; j++) {
				if ((int) rows[i] == row && (int) columns[j] == column) {
					continue;
				}
				if (rows[i] < 0 || columns[j] < 0 || rows[i] > (opinionField.length - 1)
						|| columns[j] > (opinionField[0].length - 1)) {
					continue;
				}

				if (opinionField[(int) rows[i]][(int) columns[j]] == 'a') {
					countA++;
				} else {
					countB++;
				}
			}
		}
		computeOpinion(countA, countB);
	}

}
