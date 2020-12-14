package com.github.kadehar.ui.page;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {
    private final Logger logger = LoggerFactory.getLogger(BasePage.class);

    public void open(String url) {
        logger.info("Open page by link {}", url);
        Selenide.open(url);
    }
}
