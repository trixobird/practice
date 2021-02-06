package io.happyharbor.testscore.converters;

import io.happyharbor.testscore.annotations.StringArrayParam;
import junitparams.converters.Converter;

public class StringArrayConverter implements Converter<StringArrayParam, String[]> {


    public void initialize(StringArrayParam intArrayParam) {
        // Nothing to initialize
    }

    public String[] convert(Object o) {
        final String str = (String) o;
        return str.split(";");
    }
}
