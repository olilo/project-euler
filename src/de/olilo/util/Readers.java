package de.olilo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Readers {

    public static List<String> readCommaSeparatedValues(Reader reader) throws IOException {
        final List<String> names = new ArrayList<>();
        final BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            for (String name : line.split(",")) {
                names.add(name.substring(1, name.length() - 1));
            }
            line = bufferedReader.readLine();
        }
        return names;
    }

}
