package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println("Total income:");
        int totalSeats = rows * seats;
        int profit = 0;
        if (totalSeats <= 60) { // if totalSeats <= 60 ---- income = totalSeats * 10;
            profit = totalSeats * 10;
        } else if (rows % 2 == 0) { //if the number of rows is even
            // the tickets are 10 dollars for the front half of the rows and 8 dollars for the back half
            profit = (rows / 2) * seats * 10 + (rows / 2) * seats * 8;
        } else if (rows % 2 == 1) { // if the number of rows is odd
            // the first half is the first 4 rows, and the second half is the other 5 rows. backRows = rows - frontRows
            profit = (rows / 2) * seats * 10 + (rows - (rows/2)) * seats * 8;
        }
        System.out.println("$" + profit);
        
        
    }
}
