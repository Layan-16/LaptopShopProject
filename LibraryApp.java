import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;
    int quantity;

    Book(String t, String a, double p, int q) {
        title = t;
        author = a;
        price = p;
        quantity = q;
    }

    public String toString() {
        return title + " - " + author + " - $" + price + " - " + quantity + " copies";
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Book[] books = new Book[100];
        int count = 0;
        double totalSales = 0;
        
        int choice = 0;
        
        while (choice != 6) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Buy Book");
            System.out.println("5. Show Total Sales");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter title: ");
                String t = sc.nextLine();
                System.out.print("Enter author: ");
                String a = sc.nextLine();
                System.out.print("Enter price: ");
                double p = sc.nextDouble();
                System.out.print("Enter quantity: ");
                int q = sc.nextInt();
                sc.nextLine();
                
                books[count] = new Book(t, a, p, q);
                count++;
                System.out.println("Book added!");
                
            } else if (choice == 2) {
                if (count == 0) {
                    System.out.println("No books available.");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.println(books[i]);
                    }
                }
                
            } else if (choice == 3) {
                System.out.print("Enter title to search: ");
                String searchTitle = sc.nextLine();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (books[i].title.equalsIgnoreCase(searchTitle)) {
                        System.out.println("Found: " + books[i]);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }
                
            } else if (choice == 4) {
                System.out.print("Enter title to buy: ");
                String buyTitle = sc.nextLine();
                System.out.print("Enter quantity: ");
                int buyQty = sc.nextInt();
                sc.nextLine();
                
                boolean bought = false;
                for (int i = 0; i < count; i++) {
                    if (books[i].title.equalsIgnoreCase(buyTitle)) {
                        if (books[i].quantity >= buyQty) {
                            books[i].quantity -= buyQty;
                            double cost = books[i].price * buyQty;
                            totalSales += cost;
                            System.out.println("Purchase successful! Cost: $" + cost);
                        } else {
                            System.out.println("Not enough copies.");
                        }
                        bought = true;
                    }
                }
                if (!bought) {
                    System.out.println("Book not found.");
                }
                
            } else if (choice == 5) {
                System.out.println("Total sales: $" + totalSales);
                
            } else if (choice == 6) {
                System.out.println("Thank you!");
            } else {
                System.out.println("Invalid choice.");
            }
        }
        
    }
}