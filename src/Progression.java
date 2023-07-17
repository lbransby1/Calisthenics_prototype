import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Progression {
    LinkedHashMap<String, Integer> progression;
    String type;
    String progressionName;
    private String temp;

    Progression() {
        type = inputProgString("Enter the type of exercise, (Pull, Push, Legs, Misc)");
        progressionName = inputProgString("Enter the name of the final progression");
        this.progression = new LinkedHashMap<>();
        boolean newProg = true;
        while (newProg == true) {
            String prog = inputProgString("\nEnter the name of the next progression towards the " + this.progressionName + ", or type 'exit' or 'save'");
            if (prog.equals("Exit")) {
                return;
            }
            if (prog.equals("Save")) {
                try {
                    this.save();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    return;
                }
            } else {
                progression.put(prog, inputProgReps("Enter the number of reps / hold count on " + temp));
            }
        }
    }

    public void save() {
        File file = new File("src/Progressions/" + type + "/" + progressionName + ".csv");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Integer> entry : progression.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());// new line
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    public static Progression get(String file) {
        select();

        BufferedReader reader = null;
        String line = "";
        LinkedHashMap progression = new LinkedHashMap<String, Integer>();
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                int reps = Integer.valueOf((row[1]));
                progression.put(row[0], reps);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(Collections.singletonList(progression));
        }
        Progression p = new Progression();
        p.progression = progression;
        return p;
    }

    public static void select() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String inputType = null;
        while (valid == false) {
            System.out.println("Enter the type of exercise? [Pull, Push, Legs, Misc]");
            inputType = regToTC(scanner.nextLine());
            switch (inputType) {
                case "Pull":
                    valid = true;
                    break;
                case "Push":
                    valid = true;
                    break;
                case "Legs":
                    valid = true;
                    break;
                case "Misc":
                    valid = true;
                    break;
                default:
                    System.out.println("That is not a valid selection");
                    break;
            }
        }
        File file = new File("src/Progressions/" + regToTC(inputType));
        String[] exerciseList;
        exerciseList = file.list();
        System.out.println("Select one of the following exercises:");
        for (String exercise : exerciseList) {
            System.out.println(exercise);
        }
    }

    private String inputProgString(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        temp = string;
        return regToTC(string);
    }

    private Integer inputProgReps(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean accepted = false;
        Integer num = 0;
        while (accepted == false)
            try {
                num = Integer.parseInt(scanner.nextLine());
                if ((num > -1)) {
                    accepted = true;
                    return num;
                } else {
                    throw new Exception("fail");
                }
            } catch (Exception e) {
                System.out.println("That input is invalid\n" + message);
            }
        temp = "";
        return num;
    }

    public static String regToTC(String input) {
        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }

    // TODO create a TC to camelCase

}