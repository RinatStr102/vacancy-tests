package vacancy.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class VacancySteps {
    // Открытие сайта
    @Step("Открываем сайт {url}")
    public void openSite (String url) {
        Selenide.open(url); // ОТкрываем сайт вакансии
    }

    // Поиск вакансии по запросу
    @Step("Ищем вакансию по запросу {query}")
    public void searchVacancies(String query) {
        $("input[name='text']").setValue(query).pressEnter(); //Находим поле, вводим запрос и жмем Enter
    }

    // Проверяем, что в результатах есть текст
    @Step("Проверяем, что результаты содержат текст {expectedText}")
    public void checkResults(String expectedText) {
        $("selector").shouldHave(text(expectedText)); // Проверяем текст на странице результатов
    }

}
