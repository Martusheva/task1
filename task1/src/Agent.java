import java.util.Random;

class Agent {
	private boolean stubborn;
	private char opinion;
	private boolean conformist;
	
	// �����, ����������� ������ ������ ������
	public char getOpinion() {
		return opinion;
	}

	// �����, ������� �������� �� ������-���������� ���������� � ��� �� ����� ������
	// ������ ���� ������ �����
	public void changeOpinion(char change) {
		if (!stubborn) {
			opinion = change;
		}

	}

	// �����, ������� ��������� �������� ���������� � ���, ����� ������� ����� �����
	// ��������� ������ �������
	
	public String getMethod() {
		return null;
	}
	

	// �����, ������� ��������� �������� ���������� � ���, �������� �� ����� �������
	public String getSt() {
		if (stubborn) {
			return "Stubborn";
		} else {
			return "Not stubborn";
		}
	}

	// �������� ������, ��� �����
	public Agent() {
		Random r = new Random();
		char[] opinions = { 'a', 'b' };
		opinion = opinions[r.nextInt(opinions.length)];
		stubborn = Math.random() < 0.5;
		conformist = Math.random() < 0.5;
	}

	// �������� ������, ������ �� �����
	public Agent(boolean a, boolean st,boolean cf) {
		if (a) {
			opinion = 'a';
		} else {
			opinion = 'b';
		}
		stubborn = st;
		conformist = cf;
	}

	// ������, �������� � ����� ������������
	public String isConformist() {
		if (conformist) {
			return "Conformist";
		} else {
			return "Nonconformist";
		}
	}

	// ��������� ������ ������ �� �������� ������
	public void computeOpinion(int countA, int countB) {
		int W = countA + countB;
		Random r = new Random();
		int D = r.nextInt(W) + 1;
		// System.out.println("D="+D+"\tW="+W);
		boolean opinionShareA = D <= countA;
		if (conformist) {
			if (opinionShareA) {
				changeOpinion('a');
			} else {
				changeOpinion('b');
			}
		} else {
			if (opinionShareA) {
				changeOpinion('b');
			} else {
				changeOpinion('a');
			}
		}
	}

	public void bypass(char[][] opinionField, int i, int j) {
		
	}

}