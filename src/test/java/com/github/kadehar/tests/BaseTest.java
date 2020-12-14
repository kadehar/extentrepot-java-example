package com.github.kadehar.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ex.ElementShould;
import org.junit.jupiter.api.extension.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.kadehar.helpers.ConfigHelper.report;

public class BaseTest implements BeforeAllCallback, BeforeTestExecutionCallback,
        AfterAllCallback, AfterTestExecutionCallback {
    private final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    static ExtentReports reports;
    static ExtentTest test;

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        logger.info("Report base directory: {}", report().directory());
        logger.info("Report name: {}", report().name());
        String fileName = report().directory() + report().name();
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
        Configuration.headless = true;
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        test = reports.createTest(context.getDisplayName());

        test.log(Status.INFO, context.getDisplayName() + " - started");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (!context.getExecutionException().isPresent()) {
            test.pass(context.getDisplayName() + " - passed");
        } else {
            test.fail(context.getExecutionException().get().getLocalizedMessage());
            test.addScreenCaptureFromPath(((ElementShould) context.getExecutionException().get()).getScreenshot());
        }
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        reports.flush(); //close reporter resources
        Selenide.closeWebDriver();
    }
}
