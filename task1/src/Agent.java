import java.util.Random;

class Agent extends Consideration {
	private boolean stubborn;
	private char opinion;
	private char method;

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
	public char getMethod() {
		return method;
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
		char[] methods = { 'c', 'r', 'f' };
		opinion = opinions[r.nextInt(opinions.length)];
		stubborn = Math.random() < 0.5;
		method = methods[r.nextInt(methods.length)];
	}

	// �������� ������, ������ �� �����
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

	// ������, �������� � ����� ������������
	public String isConformist() {
		return null;
	}

	// ��������� ������ ������ �� �������� ������
	public void computeOpinion(int countA, int countB) {

	}

}