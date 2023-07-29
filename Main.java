import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main   {

    public static void main(String[] args) {

        int choice, num_acc, num_friends;
    
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
            System.out.println("MAIN MENU:\n[1] Get friend list\n[2] Get connection\n[3] Exit\n");
            System.out.print("Enter your choice: ");

            choice = scn.nextInt();

            switch(choice)  {
                case 1:
                    System.out.print("Enter Account Number: ");
                    choice = scn.nextInt();
                    graph.displayFriends(choice);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
            
            // proceed with menu features

            

            
        } catch (FileNotFoundException e)   {
            System.err.println("File not found.");
        }
        

        scn.close();


    }
}