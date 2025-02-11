/*
 Problem Statement: Create a system to manage social media friend connections using a singly linked list. Each node represents a user with User ID, Name, Age, and List of Friend IDs. Implement the following operations:
Add a friend connection between two users.
Remove a friend connection.
Find mutual friends between two users.
Display all friends of a specific user.
Search for a user by Name or User ID.
Count the number of friends for each user.
Hint:
Use a singly linked list where each node contains a list of friends (which can be another linked list or array of Friend IDs).
For mutual friends, traverse both lists and compare the Friend IDs.
The List of Friend IDs for each user can be implemented as a nested linked list or array.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friends;  // List of Friend IDs
    User next;  // Pointer to next user in the singly linked list

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }

    // Add a friend connection
    public void addFriend(int friendId) {
        if (!friends.contains(friendId)) {
            friends.add(friendId);
        }
    }

    // Remove a friend connection
    public void removeFriend(int friendId) {
        friends.remove(Integer.valueOf(friendId));
    }
}

class SocialMediaSystem {
    private User head = null;  // Head of the singly linked list
    private int totalUsers = 0;

    // Add a user to the list
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        totalUsers++;
    }

    // Find a user by name or userId
    public User findUser(String searchTerm) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(searchTerm) || Integer.toString(temp.userId).equals(searchTerm)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.addFriend(userId2);
            user2.addFriend(userId1);
            System.out.println("Friend connection established between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Remove a friend connection between two users
    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            user1.removeFriend(userId2);
            user2.removeFriend(userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>();
            for (int friendId1 : user1.friends) {
                for (int friendId2 : user2.friends) {
                    if (friendId1 == friendId2) {
                        mutualFriends.add(friendId1);
                    }
                }
            }
            if (!mutualFriends.isEmpty()) {
                System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
            } else {
                System.out.println("No mutual friends between " + user1.name + " and " + user2.name);
            }
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a specific user
    public void displayFriends(int userId) {
        User user = findUserById(userId);

        if (user != null) {
            if (user.friends.isEmpty()) {
                System.out.println(user.name + " has no friends.");
            } else {
                System.out.println(user.name + "'s friends: " + user.friends);
            }
        } else {
            System.out.println("User not found.");
        }
    }

    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMediaSystem system = new SocialMediaSystem();

        while (true) {
            System.out.println("\nSocial Media System:");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends of a User");
            System.out.println("6. Search for a User");
            System.out.println("7. Count Friends");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    system.addUser(userId, name, age);
                    break;

                case 2:
                    System.out.print("Enter User ID 1: ");
                    int userId1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId2 = sc.nextInt();
                    system.addFriendConnection(userId1, userId2);
                    break;

                case 3:
                    System.out.print("Enter User ID 1: ");
                    int userId3 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId4 = sc.nextInt();
                    system.removeFriendConnection(userId3, userId4);
                    break;

                case 4:
                    System.out.print("Enter User ID 1: ");
                    int userId5 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int userId6 = sc.nextInt();
                    system.findMutualFriends(userId5, userId6);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    int userId7 = sc.nextInt();
                    system.displayFriends(userId7);
                    break;

                case 6:
                    System.out.print("Enter User Name or User ID: ");
                    String searchTerm = sc.nextLine();
                    User user = system.findUser(searchTerm);
                    if (user != null) {
                        System.out.println("User found: " + user.name + ", Age: " + user.age);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 7:
                    system.countFriends();
                    break;

                case 8:
                    system.displayUsers();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
