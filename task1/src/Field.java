import java.io.FileOutputStream;
import java.io.IOException;

public class Field {
	private Agent[][] field;

	public Field(Agent[][] agents) {
		field = agents;
	}

	// получение поля мнений
	public char[][] getField() {
		char[][] massive = new char[field.length][field[0].length];
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				massive[i][j] = field[i][j].getOpinion();
			}
		}
		return massive;
	}

	// получение информации о поле с агентами (являются ли они конформистами, какое
	// у них мнение, являются ли упертыми и метод учета мнений) вывод в консоль
	public void getDescription() {

		System.out.println("\n" + "conformists/nonconformists");
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				System.out.print(field[k][l].isConformist() + "\t");
			}
			System.out.println();
		}

		System.out.println("\n" + "opinion a/b");
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				System.out.print(field[k][l].getOpinion() + "\t");
			}
			System.out.println();
		}

		System.out.println("\n" + "stubborn or not");
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				System.out.print(field[k][l].getSt() + "\t");
			}
			System.out.println();
		}

		System.out.println("\n" + "crest/rim/fullGrafh");
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				System.out.print(field[k][l].getMethod() + "\t");
			}
			System.out.println();
		}

	}

	// учет мнения и вызов метода смены мнения
	public void computeOpinion() {
		char[][] opinionField = getField();
		for (int i = 0; i < opinionField.length; i++) {
			for (int j = 0; j < opinionField.length; j++) {
					field[i][j].bypass(opinionField, i, j);
			}
		}
	}

	// записываем в файл поле с мнением агентов, энтропию и долю мнения А
	public void toFile(FileOutputStream file, int iteration) throws IOException {
		file.write(("Time\t" + iteration + "\n").getBytes());
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				Agent agent = field[k][l];
				byte[] cell;
				if (agent.getSt().contentEquals("Stubborn")) {
					cell = (agent.getOpinion() + "*\t").getBytes();
				} else {
					cell = (agent.getOpinion() + "\t").getBytes();
				}

				file.write(cell);
			}
			file.write(("\n").getBytes());
		}
		file.write(("Entropy\t" + entropy() + "\n").getBytes());
		file.write(("Share opinion A\t" + getShareA() + "\n\n").getBytes());
	}

	// рассчитываем долю мнения А
	public float getShareA() {
		float n = 0;
		float a = 0;
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				// System.out.println("opinion "+field[k][l].getOpinion() );
				if (field[k][l].getOpinion() == 'a') {

					a++;
				}
				n++;
			}
		}
		float share = a / n;
		return share;
	}

	// рассчитываем энтропию
	public double entropy() {
		double n = 0;
		double a = 0;
		double b = 0;
		double s = 0;
		for (int k = 0; k < field.length; k++) {
			for (int l = 0; l < field[0].length; l++) {
				// System.out.println("opinion "+field[k][l].getOpinion() );
				if (field[k][l].getOpinion() == 'a') {

					a++;
				} else {
					b++;
				}
				n++;
			}
		}
		// System.out.println("a\t"+a+"\nb\t"+b+"\nn\t"+n);
		double pA = a / n;
		double pB = b / n;
		// System.out.println("pA\t"+pA+"\npB\t"+pB);
		if (pA > 0) {
			s = s - pA * (Math.log(pA) / Math.log(2));
		} else {
			s = s - pA * a;
		}
		if (pB > 0) {
			s = s - pB * (Math.log(pB) / Math.log(2));
		} else {
			s = s - pB * b;
		}
		return s;
	}
}
