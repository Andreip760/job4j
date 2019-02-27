package ru.job4j.tracker;
/**
 * Singleton for Tracker
 * Static field. Lazy loading.
 * @author Andrei Pashchenko.
 * @version 1
 * @since 26.02.2019
 */
public class TrackerSingleLazySF {
    private static TrackerSingleLazySF instance;

    private TrackerSingleLazySF() {
    }
    /**
     * Creating instance if it is not exist
     * @return Instance.
     */
    public static TrackerSingleLazySF getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazySF();
        }
        return instance;
    }
}
