import java.util.Random;

class Conformists extends Agent {
	public Conformists(boolean a, boolean st) {
		super(a, st);
	}

	public Conformists() {
		super();
	}

	@Override // �������� �� ����� ������������
	public String isConformist() {
		return "Conformist";
	}

	@Override // ����� ������ ������ �� �������� ������
	public void computeOpinion(int countA, int countB) {// c-cross, r - rim, f - full graph
		int W = countA + countB;
		Random r = new Random();
		int D = r.nextInt(W) + 1;
		// System.out.println("D="+D+"\tW="+W);
		boolean opinionShareA = D <= countA;
		if (opinionShareA) {
			changeOpinion('a');
		} else {
			changeOpinion('b');
		}

	}
}
