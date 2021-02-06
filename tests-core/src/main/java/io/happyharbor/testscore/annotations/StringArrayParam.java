package io.happyharbor.testscore.annotations;

import io.happyharbor.testscore.converters.StringArrayConverter;
import junitparams.converters.Param;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Param(converter = StringArrayConverter.class)
public @interface StringArrayParam {
}
