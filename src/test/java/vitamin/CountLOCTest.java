package vitamin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountLOCTest {

    @Test
    public void count() {

        String input;
        int expectedResult;

        input = "public class Example3 {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello world\"); // say hello\n" +
                "    }\n" +
                "}";
        expectedResult = 5;
        assertEquals(expectedResult, CountLOC.count(input));

        input = "/*\n/****//*\nA hello world program\n*\\/\n*/// -----------------\nclass Example5 {\npublic static void main(String[] args) {\nSystem.out./*  */println(\"/*\"Hello world\")\n;\n///*\n}\n/* // */ }";
        expectedResult = 6;
        assertEquals(expectedResult, CountLOC.count(input));


    }
}