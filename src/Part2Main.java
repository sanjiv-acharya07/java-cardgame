import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Part2Main {
    public static void main(String[] args) {
        //InputOutput.readWriteInputOutput(args, "part2");
        String part = "part2";
        File file = new File(part + "/outputs/output" + "10");
        try {
            String input = readInput(part + "/inputs/" + "input100");
            String output = "";
            //TODO
            //The output should be the solution to the test case input
            if (part.equals("part1")) {
                Part1Main part1Main = new Part1Main();
                output = part1Main.solve(input);
            } else {
                Part2Main part2Main = new Part2Main();
                String fakeOutput = part2Main.solve(input);
                output = fakeOutput.replace(";", "\n");

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

    //TODO (implement part 2 solution here)
    public String solve(String input) {
        BinaryTree tree = new BinaryTree();
        String[] lines = input.split("\n");
        StringBuilder allOutputs = new StringBuilder();
        int numScores = 0;
        for (int i=0; i < 2; i++) {
            if (i==0) { //Sees if line is inserting
                String[] players = lines[i].split(";");


                for (int k=0; k < players.length - 1; k++) {


                    String[] stats = players[k].split(":");
                    stats[1] = stats[1].replace(" ", "");

                    if (stats[0].contains(" ")) {
                        stats[0] = stats[0].replace(" ", "");
                    }
                    Player newPlayer = new Player(stats[0], Integer.parseInt(stats[1]));
                    tree.insert(newPlayer);

                }
            } else if (i==1) {
                numScores = Integer.parseInt(lines[i]);
            }
        }
        for (int j=2; j < (numScores + 2); j++) {
            char[] dirs = lines[j].toCharArray();
            allOutputs.append(tree.obfuscation(dirs)).append(";");
        }


        return allOutputs.toString();

    }

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
