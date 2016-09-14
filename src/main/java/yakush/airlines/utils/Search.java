package yakush.airlines.utils;

import java.util.Set;

public class Search {

    public static String searchResultAsString(Set searchResult) {

        StringBuilder string = new StringBuilder();

        for(Object element: searchResult) {
            string.append("--------------------").append("\n");
            string.append(element.toString());
        }

        return string.toString();

    }

}
