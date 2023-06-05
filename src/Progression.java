import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.*;


public class Progression {
    HashMap<String, Integer> progression;
    String finalProg;
    private String temp;
    public void addProgression(){
        finalProg = inputProgString("Enter the name of the final progression");
        this.progression = new HashMap<String, Integer>();
        boolean newProg = true;
        while (newProg == true) {
            if (inputProgString("Do you want to enter another progression towards the " + finalProg + "? (y/n)").equals("y")) {
                progression.put(inputProgString("Enter the name of a progression towards the " + this.finalProg), inputProgReps("Enter the number of reps / hold count on " + temp));
            }
            else {
                newProg = false;
            };
        }
    }

    private String inputProgString(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        temp = string;
        return string;
    }
    private Integer inputProgReps(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean accepted = false;
        Integer num = 0;
        while (accepted == false)
        try{
            num = Integer.parseInt(scanner.nextLine());
            if ((num>-1)){accepted = true;
                return num;
            }
            else{throw new Exception("fail");}
        }
        catch(Exception e){System.out.println("That input is invalid\n" + message);}
        temp = "";
        return num;
    }
}
