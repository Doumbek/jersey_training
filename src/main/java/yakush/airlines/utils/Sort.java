package yakush.airlines.utils;

import java.util.*;

public class Sort {

    public static void sort(List list, Comparator comparator, boolean desc) {

        Collections.sort(list, comparator);

        if(desc) {
            Collections.reverse(list);
        }

    }

}
