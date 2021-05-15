
public class FullGraph extends Agent {
	public FullGraph(boolean a, boolean st, boolean cf) {
		super(a, st, cf);
	}

	public FullGraph() {
		super();
	}
	
	@Override
	public String getMethod() {
		return "Full graph";
	}
	
	@Override
	public void bypass(char[][] opinionField, int row, int column) {
		int countA;
		int countB;
		int i = (int) (Math.random() * opinionField.length);
		int j = (int) (Math.random() * opinionField[0].length);
		while (i == row && j == column) {
			i = (int) (Math.random() * opinionField.length);
			j = (int) (Math.random() * opinionField[0].length);
		}
		// System.out.println(""+i+"\t"+j);
		if (opinionField[i][j] == 'a') {
			countA = 1;
			countB = 0;
		} else {
			countA = 0;
			countB = 1;
		}
		computeOpinion(countA, countB);
	}
}
