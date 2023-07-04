package com.epam.rd.autocode.startegy.cards.strategies;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BridgeCardDealingStrategy implements CardDealingStrategy {
    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> stacks = new LinkedHashMap<>();
        for (int i = 1; i <= players; i++) {
            stacks.put("Player " + i, new ArrayList<>());
        }
        stacks.put("Remaining", new ArrayList<>());

        int cardsPerPlayer = 13;

        // Deal cards to players
        for (int round = 1; round <= cardsPerPlayer; round++) {
            for (int i = 1; i <= players; i++) {
                Card card = deck.dealCard();
                stacks.get("Player " + i).add(card);
            }
        }

        // Remove the "Remaining" stack if it's empty
        if (stacks.get("Remaining").isEmpty()) {
            stacks.remove("Remaining");
        }

        return stacks;
    }
}
