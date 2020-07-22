package com.task.two;

import org.testng.annotations.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class Main {

    public enum Priority {
        Blocker, Critical, Major, Minor
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE) //on class level
    public @interface TestMethodInfo {

        //Приоритет теста
        Priority priority() default Priority.Major;

        //Автор теста
        String author() default "Bill Gates";

        //Дата последних изменений в тесте
        String lastModified() default "01.01.2019";
    }

    @Test
    public void annotation() {
        assertEquals(1, 1);

        TestMethodInfo testMethodInfo = Tmp.class.getAnnotation(TestMethodInfo.class);
        Method[] methods = TestMethodInfo.class.getDeclaredMethods();

        Object[] values = new Object[]{testMethodInfo.priority(), testMethodInfo.author(), testMethodInfo.lastModified()};

        for (int i = 0; i < methods.length; i++) {
            System.out.println(String.format("Method name: %s, value: %s", methods[i].getName(), values[i]));
        }
    }

    @TestMethodInfo(priority = Priority.Critical, author = "Test user", lastModified = "20.08.2019")
    class Tmp { }
}
