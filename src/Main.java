import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) {

		readFile("./files/text.txt");
		String filePath = "./files/text_new.txt";
	}

	private static void readFile(String path) {
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while (bufferedReader.ready()) {
				String line = bufferedReader.readLine();

				FileWriter fileStream = new FileWriter("./files/text_new.txt", true);
				BufferedWriter writer = new BufferedWriter(fileStream);
				System.out.println(line);
				line = line.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
				System.out.println(line);
				writer.write(line);
				writer.newLine();

				writer.flush();
				writer.close();

			}

			bufferedReader.close();

		} catch (Exception e) {
			System.out.println("Error while reading a file.");
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
}
