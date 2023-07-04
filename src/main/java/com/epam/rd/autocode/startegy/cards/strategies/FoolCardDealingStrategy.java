package com.epam.rd.autocode.startegy.cards.strategies;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FoolCardDealingStrategy implements CardDealingStrategy {

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> stacks = new LinkedHashMap<>();
        for (int i = 1; i <= players; i++) {
            stacks.put("Player " + i, new ArrayList<>());
        }
        stacks.put("Trump card", new ArrayList<>());
        stacks.put("Remaining", new ArrayList<>());

        // Deal cards to players
        for (int round = 1; round <= 6; round++) {
            for (int i = 1; i <= players; i++) {
                Card card = deck.dealCard();
                stacks.get("Player " + i).add(card);
            }
        }

        // Deal a card to the "Trump card" stack
        Card trumpCard = deck.dealCard();
        stacks.get("Trump card").add(trumpCard);

        // Deal remaining cards to the "Remaining" stack
        while (deck.size() > 0) {
            Card card = deck.dealCard();
            stacks.get("Remaining").add(card);
        }

        return stacks;
    }
}
