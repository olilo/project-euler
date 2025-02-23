package de.olilo.euler.level1;

import de.olilo.util.Readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem22Names {

    public int sumOfNameScores(Reader reader) throws IOException {
        final List<String> names = Readers.readCommaSeparatedValues(reader);
        Collections.sort(names);
        int sum = 0;
        for (int i = 1; i <= names.size(); i++) {
            sum += valueOf(names, i);
        }
        return sum;
    }

    public int valueOf(List<String> names, int position) {
        if (position < 1 || position > names.size()) {
            return 0;
        }

        final String name = names.get(position - 1);
        int sum = 0;
        for (char c : name.toCharArray()) {
            sum += (int) Character.toUpperCase(c) - 64;
        }
        return sum * position;
    }

}
