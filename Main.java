import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main   {

    public static void main(String[] args) {

        int choice, choice2, num_acc, num_friends;
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
                        System.out.print("Enter Account Number: ");
                        choice = scn.nextInt();

                        try {
                           graph.displayFriends(choice); 
                        } catch(Exception e) {
                            System.out.println("User not found");
                        }
                        
                        break;
                    case 2:
                        System.out.print("Enter Account Number (1): ");
                        choice = scn.nextInt();
                        System.out.print("Enter Account Number (2): ");
                        choice2 = scn.nextInt();

                        ArrayList<Integer> connection = graph.breadthFirstSearch(choice, choice2);

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

            
            // proceed with menu features

            

            
        } catch (FileNotFoundException e)   {
            System.err.println("File not found.");
        }
        

        scn.close();


    }
}