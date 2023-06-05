public class OneRmCalc {
    public static void CalcORM(int weight, int reps){
        int orm = (int) (weight / (1.0278 - (0.0278 * reps)));
        int j=1;
        for (double i=100; i>62.5; i=i-2.5){
            System.out.println("Your " + j + " rep max is " + (orm*i)/100 + "kg");
            j++;
        }
    }
}


