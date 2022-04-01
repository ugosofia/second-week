package com.corso.java.secondweek.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationHelper<A extends Annotation> {
    public static void getAnnotation() {
        for (Field f : AnnotationHelper.class.getDeclaredFields()) {
            com.corso.java.secondweek.EmployeesDBThread.Logger logger = f.getAnnotation(com.corso.java.secondweek.EmployeesDBThread.Logger.class);
            if (logger != null)
                Logger.getInstance().info(logger.item());
        }
    }

}
