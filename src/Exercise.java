import java.io.*;
import java.util.ArrayList;

public class Exercise {
    private String name;
    private double max;
    private boolean isometric;
    private boolean weighted;
    private double weight;
    private String type;

    Exercise(){}

    public void create(){
        setName(Main.stringInput("Enter name of Exercise:"));
        setType(Main.stringInput("Enter the type"));
        setIsometric(Main.stringInput("Is it isometric? (true/false):"));
        setMax(Main.stringInput("Enter the max:"));
        setWeighted(Main.stringInput("Is it weighted? (true/false):"));
        if (isWeighted()) {
            setWeight(Main.stringInput("Enter the weight:"));
        }
        else{
            setWeight("0");
        }
        System.out.println("Saving now");

    }

    public static ArrayList<Exercise> load(){
        ArrayList<Exercise>exercises = new ArrayList<Exercise>();
        BufferedReader reader = null;
        String line = "";
        try{

            reader = new BufferedReader(new FileReader("src/Exercises.csv"));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Exercise e = new Exercise();
                e.setName(row[0]);
                e.setType(row[1]);
                e.setIsometric(row[2]);
                e.setMax(row[3]);
                e.setWeighted(row[4]);
                e.setWeight(row[5]);
                exercises.add(e);
            }

        }
        catch(Exception e){}

        return exercises;
    }

    public static void save(ArrayList<Exercise>EL){
        File file = new File("src/Exercises.csv");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < EL.size(); i++) {
                String message = EL.get(i).getName()+ "," + EL.get(i).isIsometric() + "," + EL.get(i).getType() + "," + EL.get(i).getMax() + "," + EL.get(i).isWeighted() + "," + EL.get(i).getWeight();
                writer.write(message);
                writer.newLine();
                //System.out.println(message);
            }
            writer.flush();
            try{
                writer.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        catch(Exception e){
            System.out.println("fail");
        }
    }





    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getMax() {
        return max;
    }
    public void setMax(String stringMax){
        boolean valid = false;
        double max = 0;
        while (!valid){
            try {
                max = Double.parseDouble(stringMax);
                valid = true;
            }
            catch (Exception e){
                System.out.println("Invalid double input");
                stringMax = Main.stringInput("Re-enter the max");
            }
        }
        this.max = max;
    }

    public boolean isIsometric(){
        return isometric;
    }
    public void setIsometric(String isometric){
        if(isometric.equals("true")||isometric.equals("yes")||isometric.equals("y")) {
            this.isometric = true;
        }
        else {
            this.isometric = false;
        }
    }

    public void setWeighted(String weighted){
        if(weighted.equals("true")) {
            this.weighted = true;
        }
        else {
            this.weighted = false;
        }
    }
    public boolean isWeighted(){
        return this.weighted;
    }

    public void setWeight(String stringWeight){
        boolean valid = false;
        double weight = 0.0;
        while (!valid){
            try {
                weight = Double.parseDouble(stringWeight);
                valid = true;
            }
            catch (Exception e){
                System.out.println("Invalid double input");
                stringWeight = Main.stringInput("re-enter the weight");
            }
        }
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }


}
