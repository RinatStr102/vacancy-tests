package vacancy.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
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
        $("input[name='q']").setValue(query).pressEnter(); //Находим поле, вводим запрос и жмем Enter
    }

    // Проверяем, что в результатах есть текст
    @Step("Проверяем, что результаты содержат текст {expectedText}")
    public void checkResults(String expectedText) {
        $(".vacancy-card__title").shouldHave(text(expectedText)); // Проверяем текст на странице результатов
    }

    // Проверяем, что результатов нет
    @Step("Проверяем, что результатов нет и отображается сообщение {expectedMessage}")
    public void checkNoResults(String expectedMessage) {
        $(".no-content__title").shouldHave(text(expectedMessage)); // проверяем текст "Поиск не дал результатов"
    }

    //Установка фильтра "Можно удаленно"
    @Step("Устанавливаем фильтр 'Можно забрать'")
    public void applyMiddleQualificationFilte() {
        $(".select__input").click();
        $("option[value='4']").shouldBe(visible).click();
    }

}
