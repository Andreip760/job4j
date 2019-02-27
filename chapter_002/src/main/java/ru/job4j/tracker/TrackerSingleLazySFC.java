package ru.job4j.tracker;
/**
 * Singleton for Tracker
 * Static final class. Lazy loading.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 26.02.2019
 */
public class TrackerSingleLazySFC {
    private TrackerSingleLazySFC() {
    }
    /**
     * @return Instance.
     */
    public static TrackerSingleLazySFC getInstance() {
        return Holder.INSTANCE;
    }
    /**
     * Inner class contains instance of external class
     */
    private static final class Holder {
        private static final TrackerSingleLazySFC INSTANCE = new TrackerSingleLazySFC();
    }
}
