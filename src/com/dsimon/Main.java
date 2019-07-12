package com.dsimon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
//    private static int[] baseData = new int[10];

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;

        printInstructions();
        while(!quit) {
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of grocery items.");
        System.out.println("\t 2 - To add an item to the list");
        System.out.println("\t 3 - To modify an item in the list.");
        System.out.println("\t 4 - To remove an item from the list.");
        System.out.println("\t 5 - To search for an item in the list.");
        System.out.println("\t 6 - To quit the application.");
    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Enter item: ");
        String oldItem = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(oldItem, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter the item: ");
        String itemToRemove = scanner.nextLine();
        groceryList.removeGroceryItem(itemToRemove);
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in your grocery list");
        } else {
            System.out.println(searchItem + " is not in the shopping list");
        }
    }

    public static void processArrayList() {
        // COPY ARRAY LIST
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        // THIS WILL DO IT TOO
        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        // ARRAYLIST -> ARRAY
        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }
}


//    private static void getInput() {
//        for(int i = 0; i < baseData.length; i++) {
//            baseData[i] = scanner.nextInt();
//        }
//    }
//
//    private static void printArray(int[] array) {
//        System.out.println(Arrays.toString(array));
//    }
//
//    private static void resizeArray() {
//        int[] original = baseData;
//
//        baseData = new int[12];
//
//        for (int i = 0; i < original.length; i++) {
//            baseData[i] = original[i];
//        }
//    }
