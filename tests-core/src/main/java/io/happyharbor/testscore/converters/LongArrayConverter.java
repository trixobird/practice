package io.happyharbor.testscore.converters;

import io.happyharbor.testscore.annotations.LongArrayParam;
import junitparams.converters.Converter;

import java.util.Arrays;

public class LongArrayConverter implements Converter<LongArrayParam, long[]> {


    public void initialize(LongArrayParam longArrayParam) {
        // Nothing to initialize
    }

    public long[] convert(Object o) {
        final String str = (String) o;
        final String[] longStrings = str.split(";");
        return Arrays
                .stream(longStrings)
                .mapToLong(Long::parseLong)
                .toArray();
    }
}
