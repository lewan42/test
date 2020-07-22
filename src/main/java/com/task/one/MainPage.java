package com.task.one;

public interface MainPage {

    @Selector(xpath = ".//*[@task-attr='input_search']")
    String textInputSearch();

    @Selector(xpath = ".//*[@task-attr='button_search']")
    String buttonSearch();
}
