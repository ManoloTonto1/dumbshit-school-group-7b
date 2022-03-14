
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//import JSON
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    // create main method
    public static void main(String[] args) {
        // Start any objects now like the loading from shit.
        ArrayList<Student> studenten = new ArrayList<Student>();
        LoadStudents(studenten);

        Scanner scanner = new Scanner(System.in);
        int x = 1;
        // start the menu Loop
        while (x == 1) {
            System.out.println("----------------------------------------------------");
            System.out.println("0) Exit");
            System.out.println("1) Lijst met examens");
            System.out.println("2) Lijst met studenten");
            System.out.println("3) Nieuwe student inschrijven");
            System.out.println("4) Student verwijderen");
            System.out.println("5) Examen afnemen");
            System.out.println("6) Is student geslaagd voor test?");
            System.out.println("7) Welke examens heeft student gehaald?");
            System.out.println("8) Welke student heeft de meeste examens gehaald?");
            System.out.println();
            System.out.println("----------------------------------------------------");

            int input = scanner.nextInt();
            switch (input) {
                case 0:
                    System.out.println("Goodbye");
                    x = 0;
                    saveStudents(studenten);
                    break;
                case 1:
                    System.out.println("===========================");
                    // add shit here.
                    System.out.println("===========================");
                    break;
                case 2:
                    System.out.println("===========================");
                    studenten.forEach(student -> System.out.println(student.getNaam()));
                    System.out.println("===========================");
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
            }

        }
        scanner.close();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Student> LoadStudents(ArrayList<Student> studenten) {
        // JSON parser object to parse read file
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("students.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            // System.out.println(jsonObject);

            jsonObject.forEach((key, value) -> {
                Student student = new Student(Integer.parseInt(key.toString()));

                // get children from the object
                JSONObject objectChild = (JSONObject) value;
                JSONArray arrayChild = (JSONArray) objectChild.get("gehaaldeExamens");

                // Set student nummer
                student.setNaam(objectChild.get("naam").toString());

                // create array list and set the avlues to the object
                ArrayList<String> list = new ArrayList<String>();

                for (int i = 0; i < arrayChild.size(); i++) {
                    list.add(arrayChild.get(i).toString());
                }

                student.setGehaaldeExamens(list);
                studenten.add(student);
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return studenten;

    }
    @SuppressWarnings("unchecked")
    public static void saveStudents(ArrayList<Student> studenten) {
        //create the JSON object where we will store the data from the Array list
        JSONObject root = new JSONObject();
        JSONObject students = new JSONObject();

        for (Student student : studenten) {
            //Create the child nodes to match the Schema of the JSON file
            JSONObject objectChild = new JSONObject();
            JSONArray arrayChild = new JSONArray();

            //put the name and the student number in the root of the JSON object
            objectChild.put("naam", student.getNaam());
            objectChild.put("studentNummer", student.getStudentNummer());

            //add the examen to the array
            for (String examen : student.getGehaaldeExamens()) {
                arrayChild.add(examen);
            }

            //finish up the object before writing it to the JSON file
            objectChild.put("gehaaldeExamens", arrayChild);
            root.put(student.getStudentNummer(), objectChild);
        }
            students.put("students", root);
        

        try (FileWriter file = new FileWriter("students.json")) {
            file.write(root.toJSONString());
            file.flush();
            System.out.println("Successfully saved File.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
