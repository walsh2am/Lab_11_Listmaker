import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    private static ArrayList<String> lines = new ArrayList<>();

    static void main(String[] args) {

        boolean done = false;
        Scanner in = new Scanner(System.in);

        String cmdRegEx = "[AaDdIiPpQq]"; //RegEx for menu commands
//        A – Add an item to the list
//        D – Delete an item from the list
//        I – Insert an item into the list
//        P – Print (i.e. display) the list
//        Q – Quit the program

        System.out.println("Prompts:\nA – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program");
        do{
            showList();
            String cmd = SafeInput.getRegExString(in, "Enter a command (A, D, I, P, Q)", cmdRegEx);//\nA – Add an item to the list\nD – Delete an item from the list\nI – Insert an item into the list\nP – Print (i.e. display) the list\nQ – Quit the program\nEnter", cmdRegEx);

            switch (cmd.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quitProgram();
                    break;
            }
        } while (!done);

    }


//  === Methods for each Case === //

    public static void showList(){
        System.out.println("=====================================");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
        System.out.println("=====================================");
    }

    private static void addItem(){
        Scanner in = new Scanner(System.in);
        String itemToAdd= SafeInput.getNonZeroLenString(in, "Enter an Item to add");
        lines.add(itemToAdd);
    }

    private static void deleteItem (){ //Method for deleting Item
        Scanner in = new Scanner(System.in);

        if (lines.isEmpty()){
            System.out.println("List is empty, please add an item, then try again.");

        }  else {
            int indexToDelete = SafeInput.getRangedInt(in, "Enter the item to delete", 0, lines.size());
            int itemToDelete = indexToDelete - 1;
            System.out.println();
            System.out.println("Item deleted: " + lines.get(itemToDelete));
            lines.remove(itemToDelete);

            in.nextLine();
        }
    }

    private static void insertItem (){
        Scanner in = new Scanner(System.in);

        String insertItem = SafeInput.getNonZeroLenString(in, "Enter an item to insert");
        int indexToAdd = SafeInput.getRangedInt(in, "Enter location in the index to place the item", 0, lines.size()+1);
        int itemToAddLocation = indexToAdd - 1;
        lines.add(itemToAddLocation, insertItem);

        in.nextLine();

    }

    private static void printList (){
        Scanner in = new Scanner(System.in);

        boolean YN;
        do {
            showList();
            YN = SafeInput.getYNConfirm(in, "Exit List View?");
        } while (!YN);
    }

    private static void quitProgram(){
        int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to quit? (Y/N)", "ConfirmExit",  JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION){
            System.out.println("Goodbye!");
            System.exit(0);
//            } else if (response == JOptionPane.NO_OPTION) {
//
        } else if (response == JOptionPane.CLOSED_OPTION) {
            System.out.println("Dialog closed without a selection");
        }
    }


}
