import java.util.Random;

class Agent extends Consideration {
	private boolean stubborn;
	private char opinion;
	private char method;

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
	public char getMethod() {
		return method;
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
		char[] methods = { 'c', 'r', 'f' };
		opinion = opinions[r.nextInt(opinions.length)];
		stubborn = Math.random() < 0.5;
		method = methods[r.nextInt(methods.length)];
	}

	// создание агента, исходя из файла
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

	// узнаем, является л агент конформистом
	public String isConformist() {
		return null;
	}

	// изменение мнения исходя из учтенных мнений
	public void computeOpinion(int countA, int countB) {

	}

}