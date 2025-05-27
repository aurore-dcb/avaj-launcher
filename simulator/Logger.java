package simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements AutoCloseable {

    private static Logger   instance = null;
    private FileWriter      fileWriter;
    private BufferedWriter  writer;
    private static String   output_file = "simulation.txt";

    private Logger() {
        try {
            fileWriter = new FileWriter(output_file, false);
            writer = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.out.println("Output error: " + e.getMessage());
            System.exit(1);
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void writeLog(String to_write) {
        try {
            writer.write(to_write);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Output error: " + e.getMessage());
            try {
                this.close();
            } catch (IOException e1) {
                System.out.println("Error closing the logger: " + e1.getMessage());
            }
            System.exit(1);
        }
    }

    @Override
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }
}