import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class InputOutput {
    //this method can be called with the argument list and reads the inputs and writes the output files
    //you will need to implement a call to a solution (e.g. Part1Main.solve(input)) from the correct part
    //the "part" argument should be "part1", "part2", etc.
    public static void readWriteInputOutput(String[] args, String part) {
        for (String arg : args) {
            String num = arg.substring(arg.indexOf("input") + "input".length());
            File file = new File(part +"/outputs/output" + 1);
            try {
                String input = readInput(part + "/inputs/" + "input0");
                String output = "";
                //TODO
                //The output should be the solution to the test case input
                if (part.equals("part1")) {
                    Part1Main part1Main = new Part1Main();
                    output = part1Main.solve(input);
                } else {
                    break;
                    //part 2
                }
                file.createNewFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(output);
                writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + file.getName());
                e.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //this method returns the contents of the file in the path given
    public static String readInput(String path) {
        StringBuilder content = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return content.toString();
    }

}
