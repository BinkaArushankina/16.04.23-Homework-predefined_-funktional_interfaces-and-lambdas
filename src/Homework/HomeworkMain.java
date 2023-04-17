package Homework;
import java.util.function.Function;
import java.util.function.Predicate;

public class HomeworkMain {
    public static void main(String[] args) {
        //1)Переписать лямбда-выражения для интерфейсов Checkable,Printable,Producable, StringConcate,Transformable из
        // домашнего задания и с урока на стандартных функциональных интерфейсах Java.
/*
    Napisatj sledujuschie lambdi ispolsuja naschi interface
    1. concatinirowatj stroki a i b; a+b
    2. estj stroka, esli ee dlina rawna 3 wernutj true inatsche false
    3. estj stroka string, raspetschatatj ee w wide !string!
    4. esli dlina stroki 4 to wernutj ****, a net to wernutj kak estj
    5. nitschego ne prinimaet, no petschataet "Hello World".
 */
        StringConcate stringConcate = (a,b) -> Integer.toString(a)+b;
        System.out.println(stringConcate.concat(6,6));  //66

        Checkable checkable = s -> s.length() == 3;
        System.out.println(checkable.check("abc"));  //true
        System.out.println(checkable.check("abcd"));  //false

        Printable printable = s -> System.out.println("!"+s+"!");
        printable.print("string");  //!string!

        Transformable transformable = s -> (s.length() == 4) ? "****" : s;
        System.out.println(transformable.modify("abc"));  //abc
        System.out.println(transformable.modify("abcd"));  //****

        Producable producable = () -> "Hello World";
        System.out.println(producable.produce());  //Hello World


        //2)* Написать метод, принимающий строку, содержащую слова разделенные пробелом и
        // два функциональных интерфейса - function и predicate. Метод возвращает строку.
        // Он должен предоставлять возможность реализации следующих действий:
        //1. при длине слова= 3, изменить все буквы этого слова на строчные и вернуть измененную строку
        //2. при длине слова= 4, изменить все буквы слова на заглавные и вернуть измененную строку
        //3. при длине слова= 5, изменить все буквы слова на звездочки и вернуть измененную строку
        //(т.е. должен работать таким образом при передаче в него соотвествующих лямбда выражений для каждого случая).
        //Протестировать.

        String string = "aAa bBbB cCcCc dDdDdD";

        System.out.println(stringLength(string,HomeworkMain::three,HomeworkMain::threeBoolean)); //aaa bBbB cCcCc dDdDdD
        System.out.println(stringLength(string,HomeworkMain::four,HomeworkMain::fourBoolean));  //aAa BBBB cCcCc dDdDdD
        System.out.println(stringLength(string,HomeworkMain::five,HomeworkMain::fiveBoolean));  //aAa bBbB ***** dDdDdD
    }


    public static String stringLength (String str, Function function, Predicate predicate){
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split(" ");

        for (String s : strings) {
            if (predicate.test(s)) {
                stringBuilder.append(function.apply(s)).append(" ");
            }else {
                stringBuilder.append(s).append(" ");
            }
        }
        return stringBuilder.toString();
    }
    public static Object three(Object str){
        Function<String,String> three = s -> (s.length() == 3) ? s.toLowerCase() : s;
        return three.apply(str.toString());
    }
    public static Object four (Object str){
        Function<String,String> four = s -> (s.length() == 4) ? s.toUpperCase() : s;
        return four.apply(str.toString());
    }
    public static Object five (Object str){
        Function<String,String> five = s -> (s.length() == 5) ? "*****" : s;
        return five.apply(str.toString());
    }
    public static Boolean threeBoolean (Object str){
        Predicate<String> three= s -> s.length() == 3;
        return three.test(str.toString());
    }
    public static Boolean fourBoolean (Object str){
        Predicate<String> four= s -> s.length() == 4;
        return four.test(str.toString());
    }
    public static Boolean fiveBoolean (Object str){
        Predicate<String> five= s -> s.length() == 5;
        return five.test(str.toString());
    }

}

