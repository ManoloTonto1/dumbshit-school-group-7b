package test;


import java.util.ArrayList;
import java.util.Collections;
import app.JSON;
import app.Student;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;

public class JSONMenuTest {

    @Test
    public void testRead() {
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<Student> trueOne = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde",
        "wiskunde",
        "biologie");
        trueOne.add(new Student("Manuel Lopez", 123456, exams));
        JSON json = new JSON();
        trueOne= json.LoadStudents(studenten);
        assertEquals(trueOne, studenten);
    }

    @Test
    public void testWrite() {
        ArrayList<Student> studenten = new ArrayList<>();
        ArrayList<Student> trueOne = new ArrayList<>();
        ArrayList<String> exams = new ArrayList<>();
        Collections.addAll(exams, "scheikunde",
        "wiskunde",
        "biologie");
        trueOne.add(new Student("Manuel Lopez", 123456, exams));
        JSON json = new JSON();
        boolean result = json.saveStudents(studenten);
        assertTrue(result);
    }

}
