package com.github.kadehar.ui.component;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$;

public class Search {
    private final Logger logger = LoggerFactory.getLogger(Search.class);

    private final SelenideElement searchField;

    public Search(String css) {
        logger.info("Search element in DOM by css {}", css);
        searchField = $(css);
    }

    public Search(By locator) {
        logger.info("Search element in DOM by locator {}", locator);
        searchField = $(locator);
    }

    public void searchFor(String query) {
        logger.info("Search for {}", query);
        searchField.val(query).pressEnter();
    }
}
