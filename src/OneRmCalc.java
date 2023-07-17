import java.util.Scanner;

public class OneRmCalc {
    public static void CalcORM(int reps){
        Scanner scanner = new Scanner(System.in);
        boolean weightValid = false;
        int weight = 1;
        while (weightValid == false) {
            System.out.println("Enter the weight");
            try{
                weight = Integer.parseInt(scanner.nextLine());
                weightValid = true;
            }catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }

        double orm = (weight / (1.0278 - (0.027 * reps)));
        int j=1;
        System.out.format("%-8s %-5s %n", "Reps", "Weight");
        for (double i=100; i>62.5; i=i-2.5){
            System.out.format("%-8s %-5s %n", j, (orm*i)/100 + "kg");
            j++;
        }


    }
}


