package Homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkMainTest {

    HomeworkMain homeworkMain;
    String string;
    Predicate<String>predicate;
    Function<String,String>function;

    @BeforeEach

    public void init(){
        homeworkMain = new HomeworkMain();
        string = "aAa bBbB cCcCc dDdDdD";
    }

    @Test
    public void test_StringLength_three(){
        String expected = "aaa bBbB cCcCc dDdDdD";
        predicate = s -> s.length() == 3;
        function = s -> s.toLowerCase();

        assertEquals(expected,homeworkMain.stringLength(string,function,predicate));
    }
    @Test
    public void test_StringLength_four(){
        String expected = "aAa BBBB cCcCc dDdDdD";
        predicate = s -> s.length() == 4;
        function = s -> s.toUpperCase();

        assertEquals(expected,homeworkMain.stringLength(string,function,predicate));
    }
    @Test
    public void test_StringLength_five(){
        String expected = "aAa bBbB ***** dDdDdD";
        predicate = s -> s.length() == 5;
        function = s -> "*****";

        assertEquals(expected,homeworkMain.stringLength(string,function,predicate));

    }
    @Test
    public void test_empty(){
        string= "";
        predicate= s -> s.length() == 3;
        function = s -> s.toLowerCase();

        assertEquals(string,homeworkMain.stringLength(string,function,predicate));
    }
    @Test
    public void test_StringLength_nothingChanged(){
        string= "aa bbbbbbbbbbb";
        predicate = s -> s.length() == 5;
        function = s -> "*****";

        assertEquals(string,homeworkMain.stringLength(string,function,predicate));

    }


}