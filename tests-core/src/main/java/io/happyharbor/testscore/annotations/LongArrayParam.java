package io.happyharbor.testscore.annotations;

import io.happyharbor.testscore.converters.LongArrayConverter;
import junitparams.converters.Param;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Param(converter = LongArrayConverter.class)
public @interface LongArrayParam {
}
