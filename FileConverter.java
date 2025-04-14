import java.io.*;

public class FileConverter {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        // Try-with-resources per menaxhimin automatik te burimeve
        try {
            File inputFile = new File(inputFileName);

            // Kontroll nese skedari input.txt ekziston
            if (!inputFile.exists()) {
                // Krijo skedarin bosh dhe njofto perdoruesin
                if (inputFile.createNewFile()) {
                    System.out.println("Skedari 'input.txt' nuk u gjet. U krijua automatikisht si bosh.");
                }
                return; // Dalje nga programi pasi input eshte bosh
            }

            // Hap skedarin per lexim dhe shkrim
            try (
                    BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line.toUpperCase());
                    writer.newLine(); // ruaj formatin e rreshtave
                }

                System.out.println("Konvertimi perfundoi me sukses.");
            }

        } catch (IOException e) {
            System.out.println("Ndodhi nje gabim gjate perpunimit te skedareve: " + e.getMessage());
        }
    }
}
