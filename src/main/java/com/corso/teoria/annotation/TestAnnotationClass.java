package com.corso.teoria.annotation;

import com.corso.java.secondweek.utils.Logger;

import java.lang.annotation.Annotation;

@TestAnnotation
@SingleTestAnnotation (item = " ")

public class TestAnnotationClass {

    private String annotation;
    public static boolean isAnnotationPresents(){

        Class test = TestAnnotationClass.class;

        if(test.isAnnotationPresent(TestAnnotationClass.class)) Logger.getInstance().debug("There is an annotation!");
        else Logger.getInstance().debug("There is not an annotation");
        return false;
    }
    public static void main(String[] args) {
        Class test = TestAnnotationClass.class;

        if(test.isAnnotationPresent(TestAnnotationClass.class)) Logger.getInstance().debug("There is an annotation!");
        else Logger.getInstance().debug("There is not an annotation");

        Class c = TestAnnotationClass.class;
        Annotation[] a = c.getAnnotations();

    }
}
