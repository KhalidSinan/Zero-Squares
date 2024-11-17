package com.company.jproject.Utils;

import java.sql.SQLOutput;

public class TablePrinter {

    public void printTable(String[] headers, String[][] data) {
        // Calculate the width of each column based on the headers and data
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = headers[i].length();
        }

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].length());
            }
        }

        // Print top border
        printBorder(columnWidths, true);

        // Print the header row
        printRow(headers, columnWidths);

        // Print middle border
        printBorder(columnWidths, false);

        // Print the data rows with borders in between, but avoid an extra border after the last row
        for (int i = 0; i < data.length; i++) {
            printRow(data[i], columnWidths);
            // Print a border after the row if it's not the last row
            if (i < data.length - 1) {
                printBorder(columnWidths, false);
            }
        }

        // Print bottom border
        printBorder(columnWidths, true);
    }

    private void printRow(String[] row, int[] columnWidths) {
        System.out.print("|"); // Left border
        for (int i = 0; i < row.length; i++) {
            System.out.printf(" %-"+columnWidths[i]+"s |", row[i]); // Adjust for padding and width
        }
        System.out.println(); // Move to next line
    }

    private void printBorder(int[] columnWidths, boolean isTop) {
        System.out.print("+"); // Left corner for top and middle
        for (int width : columnWidths) {
            System.out.print("-".repeat(width + 2)); // Adds width + padding
            System.out.print("+"); // Separator between columns
        }
        System.out.println(); // End of the border line
    }
}