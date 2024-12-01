package vacancy.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VacancyTests {
    VacancySteps step = new VacancySteps(); // Создаем объект для шагов

    @BeforeAll
    static void setUp() {
        Configuration.browser = "safari";
        //Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Проверка поиска вакансии 'QA Engineer'")
    public void searchQaVacancies() {
        step.openSite("https://career.habr.com/"); //открыть сайт
        step.searchVacancies("QA Engineer"); // ввести запрос
        step.checkResults("QA Engineer"); // посмотреть результаты
    }

    @Test
    @DisplayName("Проверка отсутствия результатов по некорректному запросу")
    public void searchInvalidVacancy() {
        step.openSite("https://career.habr.com/");
        step.searchVacancies("Param-pam_pam");
        step.checkNoResults("Поиск не дал результатов");
    }

    @Test
    @DisplayName("Устанавливаем фильтр 'Средний (Middle)' в разделе квалификации")
    public void searchQaVacanciesWithRemoteFilter() {
        step.openSite("https://career.habr.com/");
        step.searchVacancies("QA Engineer");
        step.applyMiddleQualificationFilte();
        step.checkResults("QA Engineer");
    }
}
