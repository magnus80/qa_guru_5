package io.qaguru.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

class LambdaStepTest {

    private static final String BASE_URL = "https://github.com/";
    private static final String SEARCH_INPUT = ".header-search-input";
    private static final String REPOSITORY = "selenide/selenide";
    private static final String ISSUE_NUMBER = "#1396";

    @DisplayName("Поиск Issue по названию")
    @Test
    void selenideIssueTest() {

        step("Открыть главную страницу " + BASE_URL, () -> {
            open(BASE_URL);
        });

        step("Найти репозиторий " + REPOSITORY, () -> {
            $(SEARCH_INPUT).click();
            $(SEARCH_INPUT).sendKeys(REPOSITORY);
            $(SEARCH_INPUT).submit();
        });

        step("Открыть репозиторий " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });

        step("Перейти в раздел Issues", () -> {
            $(withText("Issues")).click();
        });

        step("Проверить, что Issue с номером" + ISSUE_NUMBER + " существует", () -> {
            $(withText(ISSUE_NUMBER)).shouldBe(visible);
        });

    }
}
