package io.happyharbor.testscore.converters;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class IntArrayConverterTest {

    private IntArrayConverter classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new IntArrayConverter();
    }

    @Test
    public void convert() {
        int[] array = classUnderTest.convert("1;2;3;3;2;1");

        List<Integer> collect = IntStream.of(array).boxed().collect(toList());
        assertThat(collect, contains(1, 2, 3, 3, 2, 1));
    }

    @Test(expected = NumberFormatException.class)
    public void convertException() {
        classUnderTest.convert("1;2;3;3;2;a");
    }
}