package Homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkMainTest {

    HomeworkMain homeworkMain;

    @BeforeEach

    public void init(){
        homeworkMain = new HomeworkMain();
    }

    @Test
    public void test_StringLength_three(){
        String actual = "aAa bBbB cCcCc dDdDdD ";
        String expected = "aaa bBbB cCcCc dDdDdD ";

        assertEquals(expected,HomeworkMain.stringLength(actual,HomeworkMain::three,HomeworkMain::threeBoolean));
    }
    @Test
    public void test_StringLength_four(){
        String actual = "aAa bBbB cCcCc dDdDdD ";
        String expected = "aAa BBBB cCcCc dDdDdD ";

        assertEquals(expected,HomeworkMain.stringLength(actual,HomeworkMain::four,HomeworkMain::fourBoolean));
    }
    @Test
    public void test_StringLength_five(){
        String actual = "aAa bBbB cCcCc dDdDdD ";
        String expected = "aAa bBbB ***** dDdDdD ";

        assertEquals(expected,HomeworkMain.stringLength(actual,HomeworkMain::five,HomeworkMain::fiveBoolean));
    }
    @Test
    public void test_StringLength(){
        String actual = "aAa bBb cCc dDD ";
        String expected = "aaa bbb ccc ddd ";

        assertEquals(expected,HomeworkMain.stringLength(actual,HomeworkMain::three,HomeworkMain::threeBoolean));
    }


}