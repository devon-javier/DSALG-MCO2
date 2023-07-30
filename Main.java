import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main   {

    public static void main(String[] args) {

        int choice, choice2, num_acc, num_friends;
        long startTime, endTime;
        boolean exit = false;
    
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scn.nextLine();
  

        try {
            File file = new File(path);
            Scanner file_scanner = new Scanner(file);

            num_acc = file_scanner.nextInt();
            num_friends = file_scanner.nextInt();

            Graph graph = new Graph(num_acc, num_friends);

            graph.storeData(file_scanner);

            System.out.println("Graph loaded!");

            do  {

                System.out.println("MAIN MENU:\n[1] Get friend list\n[2] Get connection\n[3] Exit\n");
                System.out.print("Enter your choice: ");

                choice = scn.nextInt();

                switch(choice)  {
                    case 1:
                        System.out.print("Enter ID of person: ");
                        choice = scn.nextInt();

                        try {
                            startTime = System.currentTimeMillis();
                            graph.displayFriends(choice); 
                            endTime = System.currentTimeMillis();

                            System.out.println("\nFinal Time: " + (endTime - startTime) + "\n");
                        } catch(IndexOutOfBoundsException e) {
                            System.out.println("User not found");
                        }
                        
                        break;
                    case 2:
                        System.out.print("Enter ID of first person: ");
                        choice = scn.nextInt();
                        System.out.print("Enter ID of second person: ");
                        choice2 = scn.nextInt();

                        ArrayList<Integer> connection = new ArrayList<Integer>();

                        try {
                            startTime = System.currentTimeMillis();
                            connection = graph.breadthFirstSearch(choice, choice2);
                            endTime = System.currentTimeMillis();
                            System.out.println("\nFinal Time: " + (endTime - startTime) + "\n");
                        } catch(IndexOutOfBoundsException e) {
                            System.out.println("One of the users cannot be found");
                        }

                        if(connection.isEmpty())    {
                            System.out.println("Cannot find a connection between " + choice + " and " + choice2);
                        } else {
                            System.out.println("There is a connection between " + choice + " and " + choice2 + "!");

                            for(int i = 0; i < connection.size()-1; i++)  {
                                System.out.println(connection.get(i) + " is friends with " + connection.get(i+1));
                            }

                            System.out.println();
                        }
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }

            } while (exit == false);

        } catch (FileNotFoundException e)   {
            System.err.println("File not found.");
        }
        
        scn.close();


    }
}