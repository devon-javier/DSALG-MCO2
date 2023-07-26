import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main   {

    public static void main(String[] args) {

        int choice, num_acc, num_friends;
    
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = scn.nextLine();
  

        File file = new File(path);

        try {
            Scanner file_scanner = new Scanner(file);

            num_acc = file_scanner.nextInt();
            num_friends = file_scanner.nextInt();

            // Initialize data into graph, if graph loaded then continue

            System.out.println("Graph loaded!");
            System.out.println("MAIN MENU:\n[1] Get friend list\n[2] Get connection\n[3] Exit\n");
            System.out.print("Enter your choice: ");

            choice = scn.nextInt();

            // proceed with menu features

            

            
        } catch (Exception e)   {
            System.err.println("Something went wrong.");
        }
        

        scn.close();


    }
}