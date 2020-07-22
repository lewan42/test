package com.task.one;

public class MainPageImpl implements MainPage {
    @Override
    public String textInputSearch() {
        return ".//*[@task-attr='input_search']";
    }

    @Override
    public String buttonSearch() {
        return ".//*[@task-attr='button_search']";
    }
}
