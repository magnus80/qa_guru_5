package io.qaguru.tests;

import io.qaguru.steps.GithubSteps;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

class StepAnnotationTest {

    private static final String REPOSITORY = "selenide/selenide";
    private static final String ISSUE_NUMBER = "#1396";

    GithubSteps steps = new GithubSteps();

    @Description("Поиск Issue по названию")
    @DisplayName("Тест с аннотациями @Step")
    @Feature("Issues")
    @Story("Поиск Issue по названию")
    @Owner("magnus80")
    @Severity(CRITICAL)
    @Test
    void issueNumCheckAnnotationsTest() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository();
        steps.goToIssues();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
