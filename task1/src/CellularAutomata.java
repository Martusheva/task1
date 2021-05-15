import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CellularAutomata {
	public static Field create() throws IOException {
		int x;
		int y;
		Agent[][] agents;
		String current_path = new File(".").getCanonicalPath();
		// System.out.println(current_path); //можно посмотреть что за путь

		// читаем файл, если он есть
		try {
			BufferedReader inputFile = new BufferedReader(new FileReader(current_path + "\\input.txt"));
			// System.out.println(inputFile.readLine());
			List<String> inputs = new ArrayList<String>();
			String line = inputFile.readLine();
			while (line != null) {
				inputs.add(line);
				line = inputFile.readLine();
			}
			inputFile.close();
			// System.out.println(inputs);
			y = Integer.parseInt(inputs.get(1).split("\t")[1]);
			x = Integer.parseInt(inputs.get(0).split("\t")[1]);
			int countA = Integer.parseInt(inputs.get(2).split("\t")[1]);
			int countB = Integer.parseInt(inputs.get(3).split("\t")[1]);
			int countStA = Integer.parseInt(inputs.get(6).split("\t")[1]);
			int countStB = Integer.parseInt(inputs.get(7).split("\t")[1]);
			List<String> xyStA = new ArrayList<>(Arrays.asList(inputs.get(8).split("\t")));
			xyStA.remove(0);
			List<String> xyStB = new ArrayList<>(Arrays.asList(inputs.get(9).split("\t")));
			xyStB.remove(0);
			int countCf = Integer.parseInt(inputs.get(4).split("\t")[1]);
			int countNf = Integer.parseInt(inputs.get(5).split("\t")[1]);
			int numberOfAgent = x * y;

			if (numberOfAgent != (countA + countB) || numberOfAgent != (countCf + countNf)
					|| (countStA + countStB) > (xyStA.size() + xyStB.size())) {
				throw new IOException("The number of cells does not match the number of parameters");
			}

			agents = new Agent[x][y];

			// генерируем поле агентов
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					//генерируем мнение
					boolean a = Math.random() < 0.5;
					if (countA != 0 && countB != 0) {
						a = Math.random() < 0.5;
					} else {
						if (countB != 0) {
							a = false;
						}
						if (countA != 0) {
							a = true;
						}
					}
					if (a) {
						countA--;
					} else {
						countB--;
					}
					//генерируем конформист/нонконформист
					boolean cf = Math.random() < 0.5;
					if (countCf != 0 && countNf != 0) {
						cf = Math.random() < 0.5;
					} else {
						if (countCf != 0) {
							cf = true;
						}
						if (countNf != 0) {
							cf = false;
						}
					}
					if (cf) {
						countCf--;
					} else {
						countNf--;
					}
					//генерируем упертый/не упертый
					boolean st = false;
					if (a && xyStA.contains("" + i + ";" + j)) {
						xyStA.remove("" + i + ";" + j);
						if (countStA != 0) {
							st = true;
						} else {
							st = false;
						}
						if (st) {
							countStA--;
						}
					}
					if (!a && xyStB.contains("" + i + ";" + j)) {
						xyStB.remove("" + i + ";" + j);
						if (countStB != 0) {
							st = true;
						} else {
							st = false;
						}
						if (st) {
							countStB--;
						}
					}
					//генерируем метод учета мнений
					Random r = new Random();
					char[] methods = { 'c', 'r', 'f' };
					char method = methods[r.nextInt(methods.length)];
					
					//создаем объекты класса агент в зависимости от метода учета мнений
					if (method == 'c') {
						agents[i][j] = new Cross(a, st, cf);
					} 
					if (method=='r'){
						agents[i][j] = new Rim(a, st,cf);
					}
					if (method == 'f') {
						agents[i][j] = new FullGraph(a, st,cf);
					}
				}
			}
		} catch (Exception e) {
			// если файл не найден
			System.out.println("no file in the directory");
			x = 10; // ТУТ МОЖНО ЗАДАТЬ РАЗМЕР МАТРИЦЫ КОГДА НЕТ ФАЙЛА
			y = 10;
			agents = new Agent[x][y];
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					Random r = new Random();
					char[] methods = { 'c', 'r', 'f' };
					char method = methods[r.nextInt(methods.length)];
					
					//создаем объекты класса агент в зависимости от метода учета мнений
					if (method == 'c') {
						agents[i][j] = new Cross();
					} 
					if (method=='r'){
						agents[i][j] = new Rim();
					}
					if (method == 'f') {
						agents[i][j] = new FullGraph();
					}
				}
			}
		}

		return new Field(agents);
	}

	public static void main(String[] args) throws IOException {
		int iterations = 100;
		// создаем выходной файл
		String current_path = new File(".").getCanonicalPath();
		FileOutputStream out = new FileOutputStream(current_path + "\\out.txt");

		Field cells = CellularAutomata.create();
		for (int i = 0; i < iterations; i++) {
			cells.getDescription();
			System.out.println(cells.entropy());
			System.out.println(cells.getShareA());
			cells.toFile(out, i);
			cells.computeOpinion();

		}
		cells.getDescription();
		System.out.println(cells.entropy());
		System.out.println(cells.getShareA());
		out.close();
	}
}
