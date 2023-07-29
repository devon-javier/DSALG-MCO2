import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    private boolean[][] friendships;
    private int num_acc;                // Refers to no. of accounts
    private int num_friends;            // Refers to no. of lines in file

    public Graph(int num_acc, int num_friends)  {
        this.friendships = new boolean[num_acc][num_acc];
        this.num_acc = num_acc;
        this.num_friends = num_friends;
    }

    public void storeData(Scanner file_scanner)  {
        int currentAccount, friend;

        for(int i = 0; i < this.num_friends; i++)    {
            friend = file_scanner.nextInt();
            currentAccount = file_scanner.nextInt();

            addFriendship(currentAccount, friend);
        }
    }

    public void displayFriends(int user)    {

        ArrayList<Integer> friends = getFriends(user); 

        System.out.println("Person " + user + " has " + friends.size() + " friends!");

        System.out.print("List of friends: ");
        
        for(int i = 0; i < friends.size(); i++) {
            System.out.print(friends.get(i) + " ");
        }
    }

    public ArrayList<Integer> getFriends(int user)  {

        ArrayList<Integer> friends = new ArrayList<Integer>();

        for(int i = 0; i < num_acc; i++)    {
            if(this.checkConnection(user, i) == true)   {
                friends.add(i);
            }
        }

        return friends;
    }

    public void addFriendship(int user1, int user2) {
        friendships[user1][user2] = true;
        friendships[user2][user1] = true;
    }

    public boolean checkConnection(int user1, int user2)    {
        return friendships[user1][user2];
    }
    
}
