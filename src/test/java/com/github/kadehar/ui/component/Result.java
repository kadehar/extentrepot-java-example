package com.github.kadehar.ui.component;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class Result {
    private final Logger logger = LoggerFactory.getLogger(Result.class);

    private final List<SelenideElement> results;

    public Result(String css) {
        logger.info("Search element in DOM by css {}", css);
        results = $$(css);
    }

    public SelenideElement getFirst() {
        logger.info("First result: {}", results.get(0));
        return results.get(0);
    }
}
