package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void toStringTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        Assert.assertEquals("Nome='Alice', Cognome='Rossi', Anno di nascita=1997",
                p.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooOldYearTest(){
        new Person("Gio","Verdi",1895,"nonnosupremo", "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shortUserIdTest(){
        new Person("Jessica", "Rossi", 2002, "jess", "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spaceInUserIdTest(){
        new Person("Antonio","Ruta",2002,"toto ruta", "password");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spaceInPasswordTest(){
        new Person("Luca", "Rossi", 2005, "lucarossi", "pass word");
    }
}