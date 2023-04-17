package Homework;
import java.util.function.*;

public class HomeworkMain {
    public static void main(String[] args) {
        //1)Переписать лямбда-выражения для интерфейсов Checkable,Printable,Producable, StringConcate,Transformable из
        // домашнего задания и с урока s pomoschju стандартных функциональных интерфейсах Java.
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
        //standart funktional interface
        BiFunction<Integer,Integer,String> stringBiFunction= (a,b) -> Integer.toString(a)+b;
        System.out.println(stringBiFunction.apply(6,6));  //66

        Checkable checkable = s -> s.length() == 3;
        System.out.println(checkable.check("abc"));  //true
        System.out.println(checkable.check("abcd"));  //false
        //standart funktional interface
        Predicate<String> predicate= s -> s.length() == 3;
        System.out.println(predicate.test("abc"));  //true
        System.out.println(predicate.test("abcd"));  //false

        Printable printable = s -> System.out.println("!"+s+"!");
        printable.print("string");  //!string!
        //standart funktional interface
        Consumer<String> consumer= s -> System.out.println("!"+s+"!");
        consumer.accept("string");  //!string!

        Transformable transformable = s -> (s.length() == 4) ? "****" : s;
        System.out.println(transformable.modify("abc"));  //abc
        System.out.println(transformable.modify("abcd"));  //****
        //standart funktional interface
        Function<String,String>function= s -> (s.length() == 4) ? "****" : s;
        System.out.println(function.apply("abc"));  //abc
        System.out.println(function.apply("abcd"));  //****

        Producable producable = () -> "Hello World";
        System.out.println(producable.produce());  //Hello World
        //standart funktional interface
        Supplier<String> supplier= () -> "Hello World";
        System.out.println(supplier.get());  //Hello World


        //2)* Написать метод, принимающий строку, содержащую слова разделенные пробелом и
        // два функциональных интерфейса - function и predicate. Метод возвращает строку.
        // Он должен предоставлять возможность реализации следующих действий:
        //1. при длине слова= 3, изменить все буквы этого слова на строчные и вернуть измененную строку
        //2. при длине слова= 4, изменить все буквы слова на заглавные и вернуть измененную строку
        //3. при длине слова= 5, изменить все буквы слова на звездочки и вернуть измененную строку
        //(т.е. должен работать таким образом при передаче в него соотвествующих лямбда выражений для каждого случая).
        //Протестировать.
        HomeworkMain homeworkMain= new HomeworkMain();
        String string = "aAa bBbB cCcCc dDdDdD";

        Predicate<String>predicate3= s -> s.length() == 3;
        Function<String,String>function3= String::toLowerCase;//s -> s.toLowerCase();
        System.out.println(homeworkMain.stringLength(string,function3,predicate3)); //aaa bBbB cCcCc dDdDdD

        Predicate<String>predicate4= s -> s.length() == 4;
        Function<String,String>function4= String::toUpperCase;//s -> s.toUpperCase();
        System.out.println(homeworkMain.stringLength(string,function4,predicate4)); //aAa BBBB cCcCc dDdDdD

        Predicate<String>predicate5= s -> s.length() == 5;
        Function<String,String>function5= s -> "*****";
        System.out.println(homeworkMain.stringLength(string,function5,predicate5)); //aaa bBbB ***** dDdDdD
    }
    public String stringLength (String str, Function<String,String> function, Predicate<String> predicate){
        String[] strings = str.split(" ");

        for (int i=0; i<strings.length; i++) {
            if (predicate.test(strings[i])) {
                strings[i] = function.apply(strings[i]);
            }
        }
        return String.join(" ",strings);
    }



}

