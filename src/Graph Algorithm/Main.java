package pkg2102_project3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner A = new Scanner(System.in);
        int ix = 0;
        int fileSize = 0;
        String next, line;
        Graph newGraph;

        File file = new File("");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            next = scanner.next();
            fileSize++;
        }
        System.out.println(fileSize + " Rows Successfuly Readed.\n");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            newGraph = new Graph(fileSize);
            while ((line = bufferedReader.readLine()) != null) {
                String[] variables = line.split(",");
                newGraph.addCharacter(ix, variables[0], variables[1], Integer.parseInt(variables[2]));
                ix++;
            }
        }
        System.out.println("***GAME OF THRONES NETWORK***");
        while (true) {
            System.out.print("1) Print Closest Characters\n"
                    + "2) Print Farther Characters\n"
                    + "3) Check Connection Between Two Characters\n"
                    + "4) Shortest Path Between Two Characters\n"
                    + "5) Delete Characters' Connection\n"
                    + "6) Change Characters' Weight\n"
                    + "7) Number Of Character Groups\n"
                    + "8) Print The Lowest Weighted Connection\n"
                    + "9) Print The Greatest Weighted Connection\n"
                    + "10) Print The Whole Graph\n"
                    + "11) Print The Degree Of Character\n"
                    + "12) Exit\n"
                    + "Please Select An Option : ");
            int option = A.nextInt();
            System.out.println("****************************************");
            switch (option) {
                case 1:
                    System.out.print("Character's Name : ");
                    String closest_Name = A.next();
                    System.out.print("Threshold : ");
                    int closest_threshold = A.nextInt();

                    newGraph.ClosestCharacters(closest_Name, closest_threshold);
                    break;
                case 2:
                    System.out.print("Character's Name : ");
                    String farther_Name = A.next();
                    System.out.print("Threshold : ");
                    int farther_threshold = A.nextInt();

                    newGraph.FartherCharacters(farther_Name, farther_threshold);
                    break;
                case 3:
                    System.out.print("First Character's Name : ");
                    String Connected_character_1 = A.next();
                    System.out.print("Second Character's Name : ");
                    String Connected_character_2 = A.next();

                    newGraph.isConnected(Connected_character_1, Connected_character_2);
                    break;
                case 4:
                    System.out.print("First Character's Name : ");
                    String Shortest_character_1 = A.next();
                    System.out.print("Second Character's Name : ");
                    String Shortest_character_2 = A.next();

                    newGraph.ShortestPath(Shortest_character_1, Shortest_character_2);
                    break;
                case 5:
                    System.out.print("First Character's Name : ");
                    String Delete_character_1 = A.next();
                    System.out.print("Second Character's Name : ");
                    String Delete_character_2 = A.next();

                    newGraph.deleteCharactersConnection(Delete_character_1, Delete_character_2);
                    break;
                case 6:
                    System.out.print("First Character's Name : ");
                    String change_character_1 = A.next();
                    System.out.print("Second Character's Name : ");
                    String change_character_2 = A.next();
                    System.out.print("New Weigth : ");
                    int newWeigth = A.nextInt();

                    newGraph.changeWeight(change_character_1, change_character_2, newWeigth);
                    break;
                case 7:
                    System.out.print("Character's Name : ");
                    String Group_character = A.next();
                    newGraph.numberOfCharacterGroup(Group_character);
                    System.out.println("****************************************");
                    break;
                case 8:
                    newGraph.lowestWeights();
                    break;
                case 9:
                    newGraph.greatestWeights();
                    break;
                case 10:
                    newGraph.displayGraph();
                    break;
                case 11:
                    System.out.print("Character's Name : ");
                    String degree_character = A.next();
                    newGraph.degreeOfCharacter(degree_character);
                    break;
                case 12:
                    System.exit(0);
                    break;
            }
        }

    }

}
