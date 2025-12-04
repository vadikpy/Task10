import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputFile = "src/studentsGroup4.txt";
        String outputFile = "bestStudents.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\t");

                if (parts.length >= 3) {
                    String mark = parts[2].trim();
                    if (mark.equals("5")) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }

            System.out.println("File is ready:" + outputFile);

        } catch (IOException e) {
            System.out.println("Unexpected error:");
            e.printStackTrace();
        }
    }
}
