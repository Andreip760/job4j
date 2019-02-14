package ru.job4j.condition;
/**
 * Class for conversation with dummy bot.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 07.02.2019
 */
public class DummyBot {
    /**
     * Answer to question.
     * @param question Client's question.
     * @return Answer.
     */
    public String answer(String question) {
        String result = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            result = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            result = "До скорой встречи.";
        }
        return result;
    }
}
