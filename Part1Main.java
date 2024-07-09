
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Part1Main {
    public static void main(String[] args) {
        //InputOutput.readWriteInputOutput(args, "part1");
        String part = "part1";
        File file = new File(part + "/outputs/output" + "10");
        try {
            String input = readInput(part + "/inputs/" + "input10");
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

    //TODO (implement part 1 solution here)
    public String solve(String input) {
        CardGame cardGame = new CardGame();
        String[] lines = input.split("\n");
        for (String line : lines) {
            if (line.contains("|")) {
                //Adding a player
                String[] first = line.split("\\|");
                String data = first[1].trim();
                String[] realData = data.split(";");
                realData[1] = realData[1].replace(" ", "");
                realData[2] = realData[2].replace(" ", "");
                Player player = new Player(realData[0], Integer.parseInt(realData[1]), Integer.parseInt(realData[2]));
                cardGame.addPlayer(player);



            } else if (line.contains("DELETE")) {
                //Delete a player
                String[] first = line.split(" ");
                String name = first[1];
                for (Player player : cardGame.getTable()) {
                    if (player.getName().equals(name)) {
                        cardGame.removePlayer(player);
                        break;
                    }
                }




            } else if (line.contains("PLAY")) {
                //Play a round
                String[] first = line.split(" ");
                cardGame.play(Integer.parseInt(first[1]));


            }

        }
        StringBuilder output = new StringBuilder();
        Iterator<Player> iterator = cardGame.getPlayers().iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            output.append(player.getName()).append(": ").append(player.getScore()).append(";");
            if (iterator.hasNext()) {
                output.append(" ");
            }
        }
        return output.toString();
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
