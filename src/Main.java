import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<Exercise>exercises = Exercise.load();
        Exercise e1 = new Exercise();
        e1.create();
        exercises.add(e1);
        Exercise e2 = new Exercise();
        e2.create();
        exercises.add(e2);
        Exercise.save(exercises);


        OneRmCalc.CalcORM(4);
        //Progression.select();
        Progression newProgression = new Progression();


    }

    public static String stringInput(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }


}
