import java.util.Random;

class Nonconformists extends Agent {
	public Nonconformists(boolean a, boolean st) {
		super(a, st);
	}

	public Nonconformists() {
		super();
	}

	@Override
	public String isConformist() {
		return "Nonconformist";
	}

	@Override
	public void computeOpinion(int countA, int countB) {
		int W = countA + countB;
		Random r = new Random();
		int D = r.nextInt(W) + 1;
		// System.out.println("D="+D+"\tW="+W);
		boolean opinionShareA = D <= countA;
		if (opinionShareA) {
			changeOpinion('b');
		} else {
			changeOpinion('a');
		}
	}
}
