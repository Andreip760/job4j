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
    /**
     * Answers the UI questions.
     * Checks that the taken value is in range.
     * @param question Question
     * @param range Menu range
     * @return Answer
     * @throws MenuOutException (If answer is out of range)
     */
    @Override
    public int ask(String question, int[] range) {
        int answer = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int val : range) {
            if (val == answer) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("Answer is out of menu range");
        }
        return answer;
    }
}
