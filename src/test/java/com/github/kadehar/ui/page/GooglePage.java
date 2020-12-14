package com.github.kadehar.ui.page;

import com.github.kadehar.ui.component.Result;
import com.github.kadehar.ui.component.Search;

import static com.codeborne.selenide.Selectors.byName;

public class GooglePage extends BasePage {
    public Search search = new Search(byName("q"));
    public Result results = new Result(".g h3");
}
