import java.util.ArrayList;

public class Student {
    Examen examens;
    private String naam;
    private int studentNummer;
   // private ArrayList<Examen> gehaaldeExamens;
    private ArrayList<String> gehaaldeExamens;

    public Student(String naam, int studentNummer, ArrayList<Examen> gehaaldeExamens){
        this.naam = naam;
    }
    public Student(String naam){
        this.naam = naam;
    }
    //Getters
    public void addGehaaldeExamen(Examen examens){

    }
    //Getters
    public String getNaam() {
        return naam;
    }

    public int getStudentNummer() {
        return studentNummer;
    }

    public ArrayList<String> getGehaaldeExamens() {
        return gehaaldeExamens;
    }
    

    //Setters
    public void setStudentNummer(int studentNummer) {
        this.studentNummer = studentNummer;
    }
    public void setGehaaldeExamens(ArrayList<String> gehaaldeExamens) {
        this.gehaaldeExamens = gehaaldeExamens;
    }

}
