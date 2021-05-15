import java.util.Random;

class Agent {
	private boolean stubborn;
	private char opinion;
	private boolean conformist;
	
	// метод, позволяющий узнать мнение агента
	public char getOpinion() {
		return opinion;
	}

	// метод, который получает из класса-наследника информацию о том на какое мнение
	// меняет свое мнение агент
	public void changeOpinion(char change) {
		if (!stubborn) {
			opinion = change;
		}

	}

	// метод, который позволяет получить информацию о том, каким методом агент будет
	// учитывать мнение соседей
	
	public String getMethod() {
		return null;
	}
	

	// метод, который позволяет получить информацию о том, является ли агент упертым
	public String getSt() {
		if (stubborn) {
			return "Stubborn";
		} else {
			return "Not stubborn";
		}
	}

	// создание агента, без файла
	public Agent() {
		Random r = new Random();
		char[] opinions = { 'a', 'b' };
		opinion = opinions[r.nextInt(opinions.length)];
		stubborn = Math.random() < 0.5;
		conformist = Math.random() < 0.5;
	}

	// создание агента, исходя из файла
	public Agent(boolean a, boolean st,boolean cf) {
		if (a) {
			opinion = 'a';
		} else {
			opinion = 'b';
		}
		stubborn = st;
		conformist = cf;
	}

	// узнаем, является л агент конформистом
	public String isConformist() {
		if (conformist) {
			return "Conformist";
		} else {
			return "Nonconformist";
		}
	}

	// изменение мнения исходя из учтенных мнений
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