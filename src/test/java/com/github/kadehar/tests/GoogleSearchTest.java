package com.github.kadehar.tests;

import com.codeborne.selenide.Condition;
import com.github.kadehar.ui.page.GooglePage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BaseTest.class)
public class GoogleSearchTest {
    @Test
    @DisplayName("Search for Selenide")
    public void searchForSelenide() {
        GooglePage page = new GooglePage();

        page.open("https://www.google.com/");
        page.search.searchFor("Selenide");

        page.results.getFirst().shouldHave(Condition.text("Selenide"));
    }

    @Test
    @DisplayName("Search for Selenide (failed)")
    public void searchForSelenideFailed() {
        GooglePage page = new GooglePage();

        page.open("https://www.google.com/");
        page.search.searchFor("Selenide");

        page.results.getFirst().shouldHave(Condition.text("Selenide12"));
    }
}
