import java.util.ArrayList;
import java.util.LinkedList;
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

        System.out.println("\n");
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

    public ArrayList<Integer> breadthFirstSearch(int root, int friend)  {

        boolean[] visited = new boolean[num_acc];   // already initialized to false 
        
        LinkedList<Integer> queue = new LinkedList<>();
        int currentAccount;

        int[] previousAccounts = new int[num_acc];

        visited[root] = true;
        queue.add(root);
        previousAccounts[root] = -1;                // -1 to signify root node


        while(queue.isEmpty() == false) {
            currentAccount = queue.poll();

            if(currentAccount == friend)    {
            return getPath(previousAccounts, friend);

            } else {
                for(int i = 0; i < friendships[currentAccount].length; i++) {
                    if(this.checkConnection(currentAccount, i) && !visited[i] ) {
                        queue.add(i);
                        visited[i] = true;
                        previousAccounts[i] = currentAccount;
                    }
                }
            }
        }

        ArrayList<Integer> empty = new ArrayList<Integer>();
        return empty;                       // if friend cannot become the current account

    }

    public ArrayList<Integer> getPath(int[] previousAccounts, int friend) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        int currentAccount = friend;            // Work backwards
        int start = 0;                          // Reverse the path to go from root to friend

        while(currentAccount != -1) {           // -1 to signify root node
            path.add(start, currentAccount);
            currentAccount = previousAccounts[currentAccount];
        }

        return path;
    }

    public void addFriendship(int user1, int user2) {
        friendships[user1][user2] = true;
        friendships[user2][user1] = true;
    }

    public boolean checkConnection(int user1, int user2)    {
        return friendships[user1][user2];
    }
    
}
