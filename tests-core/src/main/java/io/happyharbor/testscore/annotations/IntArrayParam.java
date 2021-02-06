package io.happyharbor.testscore.annotations;

import io.happyharbor.testscore.converters.IntArrayConverter;
import junitparams.converters.Param;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Param(converter = IntArrayConverter.class)
public @interface IntArrayParam {
}
