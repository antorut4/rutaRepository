package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;

public class Student extends Person {

     private String studentId ;
    private int numberOfAbsences;
    private AbstractMap<String, Integer> passedExam;

    public Student(String name, String surname, int birthYear, String userId, String password, String matricola, int numberOfAbsences) {
        super(name, surname, birthYear, userId, password);
        if (studentId==null || studentId.isEmpty())
            throw new IllegalArgumentException("Matricola dello studente con formato errato");
        this.studentId=studentId;
        this.numberOfAbsences = numberOfAbsences;
        this.passedExam=new HashMap<>();
    }

    public String getMatricola(){
        return studentId;
    }

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        if(grade<18 || grade>31)
            throw new IllegalArgumentException("Voto non valido (minore di 18 o maggiore di 30 e lode");
        this.passedExam.put(examName,grade);
    }

    public int getNumberOfPassedExams() {
        return passedExam.size();
    }

    public AbstractMap<String, Integer> getPassedExams() {
        return passedExam;
    }

    public double getAverageGrade() {
        int somma=0;
        for(int grade : passedExam.values()){
            if(grade == 31)grade--;
            somma+=grade;
        }
        return somma/this.getNumberOfPassedExams();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
