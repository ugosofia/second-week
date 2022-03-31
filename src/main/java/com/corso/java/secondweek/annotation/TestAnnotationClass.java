package com.corso.java.secondweek.annotation;

import com.corso.java.secondweek.utils.LOG;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@TestAnnotation
@SingleTestAnnotation (item = " ")

public class TestAnnotationClass {

    private String annotation;
    public static boolean isAnnotationPresents(){

        Class test = TestAnnotationClass.class;

        if(test.isAnnotationPresent(TestAnnotationClass.class)) LOG.getInstance().debug("There is an annotation!");
        else LOG.getInstance().debug("There is not an annotation");
        return false;
    }
    public static void main(String[] args) {
        Class test = TestAnnotationClass.class;

        if(test.isAnnotationPresent(TestAnnotationClass.class)) LOG.getInstance().debug("There is an annotation!");
        else LOG.getInstance().debug("There is not an annotation");

        Class c = TestAnnotationClass.class;
        Annotation[] a = c.getAnnotations();

    }
}
