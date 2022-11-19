package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void toStringTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        Assert.assertEquals("Nome='Roberto', Cognome='Bianchi', Anno di nascita=2005, Numero di assenze=3",
                s.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyStudentId(){
        new Student("Jessica", "Rossi", 2002, "jessrossi", "password", "",3);
    }

    @Test
    public void addExamTest(){
        Student s= new Student("Jessica", "Rossi", 2002, "jessrossi", "password", "051216548",3);
        s.addExam("Metodi matematici per l'informatica",31);
        s.addExam("Matematica discreta",25);
        Assert.assertEquals(2,s.getNumberOfPassedExams());
    }

    @Test
    public void getAvarageTest() {
        Student s = new Student("Jessica", "Rossi", 2002, "jessrossi", "password", "051216548", 3);
        s.addExam("Metodi matematici per l'informatica", 31);
        s.addExam("Matematica discreta", 25);
        Assert.assertEquals(27.5,s.getAverageGrade(),0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInvalidGradeTest(){
        Student s = new Student("Jessica", "Rossi", 2002, "jessrossi", "password", "051216548", 3);
        s.addExam("Metodi matematici per l'informatica", 35);
    }

}