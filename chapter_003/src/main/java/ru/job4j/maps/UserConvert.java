package ru.job4j.maps;

import java.util.HashMap;
import java.util.List;
/**
 * Class for converting a user's list into a hash map
 * @author Andrei Pashchenko.
 * @version 1
 * @since 09.03.2019
 */
public class UserConvert {
    /**
     * Converting the user's list into the hash map.
     * @param list Input list.
     * @return Hash map.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
            for (User user : list) {
                result.put(user.getId(), user);
            }
        return result;
    }
}
