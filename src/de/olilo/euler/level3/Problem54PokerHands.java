package de.olilo.euler.level3;

import de.olilo.euler.Problem;
import de.olilo.euler.Runner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem54PokerHands implements Problem {

    @Override
    public String getMessage() {
        return "Player 1 wins this many times: ";
    }

    @Override
    public int getProblemNumber() {
        return 54;
    }

    @Override
    public Number runProblem(Runner runner) throws IOException {
        final FileReader reader = runner.getFileReader("54");

        int wonGames = 0;
        for (PokerCard[] cards : readCards(reader)) {
            if (playGame(cards)) {
                wonGames++;
            }
        }

        return wonGames;
    }

    protected List<PokerCard[]> readCards(Reader reader) throws IOException {
        final List<PokerCard[]> cardsList = new ArrayList<>();
        final BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();
        while (line != null) {
            final String[] cardsAsStrings = line.split(" ");
            final PokerCard[] cards = new PokerCard[cardsAsStrings.length];
            for (int i = 0; i < cardsAsStrings.length; i++) {
                cards[i] = PokerCard.getByShortVersion(cardsAsStrings[i]);
            }
            cardsList.add(cards);

            line = bufferedReader.readLine();
        }

        return cardsList;
    }

    protected boolean playGame(PokerCard[] cards) {
        final PokerPlayer player1 = new PokerPlayer(Arrays.copyOf(cards, 5));
        final PokerPlayer player2 = new PokerPlayer(Arrays.copyOfRange(cards,5,  10));
        return player1.playAgainst(player2);
    }

}
