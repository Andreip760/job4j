package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Test
 * @author Andrei Pashchenko.
 * @version 1
 * @since 26.02.2019
 */
public class TrackerSingleTest {
    /**
     * First instances of singles
     */
    private final TrackerSingleEagerEnum singleEagerEnum = TrackerSingleEagerEnum.INSTANCE;
    private final TrackerSingleLazySF singleLazySF = TrackerSingleLazySF.getInstance();
    private final TrackerSingleEagerSFF singleEagerSFF = TrackerSingleEagerSFF.getInstance();
    private final TrackerSingleLazySFC singleLazySFC = TrackerSingleLazySFC.getInstance();

    /**
     * Trying to get second enum.
     */
    @Test
    public void whenGetSecondEnumThenFirst() {
        assertThat(this.singleEagerEnum, is(TrackerSingleEagerEnum.INSTANCE));
    }
    /**
     * Trying to get second SingleLazySF.
     */
    @Test
    public void whenGetSecondSingleLazySFThenFirst() {
        assertThat(this.singleLazySF, is(TrackerSingleLazySF.getInstance()));
    }
    /**
     * Trying to get second SingleEagerSFF.
     */
    @Test
    public void whenGetSecondSingleEagerSFFThenFirst() {
        assertThat(this.singleEagerSFF, is(TrackerSingleEagerSFF.getInstance()));
    }
    /**
     * Trying to get second SingleLazySFC.
     */
    @Test
    public void whenGetSecondSingleLazySFCThenFirst() {
        assertThat(this.singleLazySFC, is(TrackerSingleLazySFC.getInstance()));
    }
}
