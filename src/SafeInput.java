import java.util.Scanner;

public class SafeInput {
    /**
     * A method that gets a non-zero length String from the User
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }

    /**
     * A method that gets an integer from the User
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return an integer response from the User
     */
    public static int getInt(Scanner pipe, String prompt)
    {

        boolean done = false;
        int val = 0;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt()){
                val = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                System.out.println("You did not enter a valid integer.");
                trash = pipe.nextLine();
            }

        } while (!done);

        return val;
    }

    /**
     * A method that gets a Double from the User
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a double value from the User
     */
    public static double getDouble(Scanner pipe, String prompt)
    {

        boolean done = false;
        double val = 0;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble()){
                val = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter Enter a valid double, not " + trash);
            }

        } while (!done);

        return val;
    }

    /**
     * A method that gets an integer from the User from a specified range
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param low the lowest value of the range
     *            @param high the lowest value of the range
     * @return a double value from the User
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        int val = 0;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt()){
                val = pipe.nextInt();
                //pipe.nextLine();
                if (val >= low && val <= high) {
                    done = true;
                } else {
                    trash = pipe.nextLine();
                    System.out.println("Integer must be between " + low + " and " + high);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter an integer in range, not " + trash);
            }

        } while (!done);
        return val;
    }



    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        boolean done = false;
        double val = 0;
        String trash = "";

        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble()){
                val = pipe.nextDouble();
                //pipe.nextLine();
                if (val >= low && val <= high) {
                    done = true;
                } else {
                    trash = pipe.nextLine();
                    System.out.println("Double value must be between " + low + " and " + high);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Enter a Double value in range, not " + trash);
            }

        } while (!done);
        return val;
    }

    /**
     * A method that gets a Y or N from the user. Returning a true boolean
     * @param pipe
     * @param prompt
     * @return
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean done = false;
        boolean retVal = false;
        String val;
        do {
            System.out.print(prompt + " [Y/N]: ");
            val = pipe.nextLine();
            if (val.equalsIgnoreCase("Y") || val.equalsIgnoreCase("N")) {
                done = true;
            } else {
                System.out.println("You did not enter a valid response; enter Y or N");
            }
        } while (!done);

        return val.equalsIgnoreCase("Y");
    }

    /**
     * A method that gets a string that matches a regular expression
     * @param pipe Scanner to read the string
     * @param prompt
     * @param regEx Regular expression to match
     * @return String that matched the Regular Expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;

        String val = "";
        do {
            System.out.print(prompt + ": ");
            val = pipe.nextLine();
            if (val.matches(regEx))
            {
                done = true;
            } else {
                System.out.println("Enter a value that matches the pattern: "+ regEx + " not: " + val);
            }
        } while (!done);
        return val;
    }


    public static void prettyHeader(String msg)
    {
        // int rowCnt = 0;
        msg = "Message Centered Here"; //msg length = 21
        int space = msg.length();
        int rowLength = 60;
        //System.out.println(space);

        for (int row=0; row<=2; row++) {
            for (int col = 0; col <= rowLength; col++) {
                if (row == 0){ //|| row == 2) {
                    System.out.print("*");
                } else if (row == 1){ //this will have to be the loop for row 2
                    if (col <=2 || col >=37) {
                        System.out.print("*");
                    } else if (col == 20){
                        System.out.print(msg);
                        rowLength = rowLength - space;
                        System.out.print(" ");
                    } else {
                        System.out.print(" ");
                    }
                } else if (row == 2){
                    rowLength = 60;
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }




}
