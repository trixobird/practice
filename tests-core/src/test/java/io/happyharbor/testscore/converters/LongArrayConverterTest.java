package io.happyharbor.testscore.converters;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class LongArrayConverterTest {

    private LongArrayConverter classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new LongArrayConverter();
    }

    @Test
    public void convert() {
        long[] array = classUnderTest.convert("1;2;3;3;2;1");

        List<Long> collect = LongStream.of(array).boxed().collect(toList());
        assertThat(collect, contains(1L, 2L, 3L, 3L, 2L, 1L));
    }

    @Test(expected = NumberFormatException.class)
    public void convertException() {
        classUnderTest.convert("1;2;3;3;2;a");
    }
}