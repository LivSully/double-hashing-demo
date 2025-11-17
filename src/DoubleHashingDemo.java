import java.util.Scanner;
public class DoubleHashingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();
        DoubleHashingHashTable hashTable = new DoubleHashingHashTable(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int keyToInsert = scanner.nextInt();
                    hashTable.insert(keyToInsert);
                    break;
                case 2:
                    System.out.print("Enter key to search: ");
                    int keyToSearch = scanner.nextInt();
                    hashTable.search(keyToSearch);
                    break;
                case 3:
                    System.out.print("Enter key to delete: ");
                    int keyToDelete = scanner.nextInt();
                    hashTable.delete(keyToDelete);
                    break;
                case 4:
                    hashTable.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
