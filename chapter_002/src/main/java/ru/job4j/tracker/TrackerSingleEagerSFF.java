package ru.job4j.tracker;
/**
 * Singleton for Tracker
 * Static final field. Eager loading.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 26.02.2019
 */
public class TrackerSingleEagerSFF {
private static final TrackerSingleEagerSFF INSTANCE = new TrackerSingleEagerSFF();

    private TrackerSingleEagerSFF() {

    }
    /**
     * @return Instance.
     */
    public static TrackerSingleEagerSFF getInstance() {
        return INSTANCE;
    }
}
