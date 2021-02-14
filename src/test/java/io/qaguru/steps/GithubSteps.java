package io.qaguru.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GithubSteps {

    private static final String BASE_URL = "https://github.com/";
    private static final String SEARCH_INPUT = ".header-search-input";
    private static final String REPOSITORY = "selenide/selenide";
    private static final String ISSUE_NUMBER = "#1396";

    @Step("Открыть главную страницу" + BASE_URL)
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Найти репозиторий {value}")
    public void searchForRepository(String value) {
        $(SEARCH_INPUT).click();
        $(SEARCH_INPUT).sendKeys(value);
        $(SEARCH_INPUT).submit();
    }

    @Step("Открыть репозиторий")
    public void goToRepository() {
        $("ul.repo-list li").$("a").click();

    }

    @Step("Перейти в раздел Issues")
    public void goToIssues() {
        $(byText("Issues")).click();

    }

    @Step("Проверить, что Issue с номером {number} существует")
    public void shouldSeeIssueWithNumber(String number) {
        $(withText(number)).shouldBe(visible);
    }
}
