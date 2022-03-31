package com.corso.java.secondweek.utils;

import com.corso.java.secondweek.EmployeesDBThread.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationHelper<A extends Annotation> {
    public static void getAnnotation() {
        for (Field f : AnnotationHelper.class.getDeclaredFields()) {
            Logger logger = f.getAnnotation(Logger.class);
            if (logger != null)
                LOG.getInstance().info(logger.item());
        }
    }

}
