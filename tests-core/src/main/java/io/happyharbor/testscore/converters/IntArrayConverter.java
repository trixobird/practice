package io.happyharbor.testscore.converters;

import io.happyharbor.testscore.annotations.IntArrayParam;
import junitparams.converters.Converter;

import java.util.Arrays;

public class IntArrayConverter implements Converter<IntArrayParam, int[]> {


    public void initialize(IntArrayParam intArrayParam) {
        // Nothing to initialize
    }

    public int[] convert(Object o) {
        final String str = (String) o;
        final String[] intStrings = str.split(";");
        return Arrays
                .stream(intStrings)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
