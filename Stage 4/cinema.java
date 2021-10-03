package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);

        // get input of rows and seats
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        char[][] cinema = new char[rows][seats];
        for (char[] row: cinema) {
            Arrays.fill(row, 'S');
        }

        while (true) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            int command = scanner.nextInt();

            if (command == 0) {
                break;
            }

            if (command == 1) {
                showTheseats(rows,seats,cinema);
            }

            if (command == 2) {
                System.out.println("Enter a row number:");
                int row = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                int seat = scanner.nextInt();
                buyAticket(row,seat,rows,seats,cinema);
            }
        }
    }

    private static void showTheseats(int rows, int seats, char[][] cinema) {
        System.out.print("Cinema:\n ");
        for (int i = 1; i <= seats; ++i) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; ++i) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; ++j) {
                System.out.print(" " + cinema[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }
    private static void buyAticket(int row, int seat, int rows, int seats, char[][] cinema) {


        int totalSeats = rows * seats;
        int frontRows = rows / 2;
        int backRowsIfEven = rows / 2;
        int backRowsIfOdd = rows - (rows / 2);
        int ticketPrice = 0;

        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else {
            if (rows % 2 == 0 ) {
                if (row <= frontRows) {
                    ticketPrice = 10;
                }
                if (row >= backRowsIfEven) {
                    ticketPrice = 8;
                }
            } else {
                if (row <= frontRows) {
                    ticketPrice = 10;
                }
                if (row >= backRowsIfOdd) {
                    ticketPrice = 8;
                }
            }

        }
        System.out.println();

        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();

        System.out.print("Cinema:\n ");

        // print the first row from 1 to the number of seats starting by the space
        for (int i = 1; i <= seats; ++i) {
            System.out.print(" " + i);
        }
        // on a new line print the array first by printing the value ''S of the array plus space for each row + 1
        System.out.println();
        for (int i = 0; i < rows; ++i) {
            System.out.print(i + 1);
            for (int j = 0; j < seats; ++j) {
                cinema[row - 1][seat - 1] = 'B';
                System.out.print(" " + cinema[i][j]);
            }
            System.out.println();
        }
    }
}
