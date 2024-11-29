package vacancy.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VacancyTests {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
    }

    @Test
    @DisplayName("Проверка поиска вакансии по запросу 'Java разработчик'")


}
