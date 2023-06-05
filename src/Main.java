public class Main{
    public static void main(String[] args){
        //OneRmCalc.CalcORM(140,4);
        //Progression p = new Progression();
        try{FileHandler.csvToLHM("src/Progressions/Pull/backLever.csv");}
        catch (Exception e){System.out.println(e);}

    }
}
