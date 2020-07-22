package com.task.one;


import org.testng.annotations.Test;
import java.lang.reflect.Proxy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class MethodInterception {

    @Test
    public void annotationValue() {

        MainPage mainPage = createPage(MainPage.class);

        assertNotNull(mainPage);
        assertEquals(mainPage.buttonSearch(), ".//*[@task-attr='button_search']");
        assertEquals(mainPage.textInputSearch(), ".//*[@task-attr='input_search']");
    }

    private MainPage createPage(Class clazz) {

        SomeInvocationHandler handler = new SomeInvocationHandler(new MainPageImpl());

        return (MainPage) Proxy.newProxyInstance(MainPageImpl.class.getClassLoader(), new Class[]{clazz}, handler);
    }
}
