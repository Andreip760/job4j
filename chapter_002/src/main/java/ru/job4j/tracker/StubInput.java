package ru.job4j.tracker;
/**
 * Stub for emulating user's input.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 18.02.2019
 */
public class StubInput implements Input {
    private final String[] value;
    private int position = 0;
    /**
     * Stub constructor.
     * @param value User's answers array.
     */
    public StubInput(String[] value) {
        this.value = value;
    }
    /**
     * Answers the UI questions.
     * @param question Question from UI.
     * @return Answer.
     */
    @Override
    public String ask(String question) {
        return value[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        return Integer.valueOf(this.ask(question));
    }
}
