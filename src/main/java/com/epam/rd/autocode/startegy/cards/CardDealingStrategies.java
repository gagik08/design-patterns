package com.epam.rd.autocode.startegy.cards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CardDealingStrategies {
    private CardDealingStrategies() {
        // Private constructor to hide the implicit public one
    }
    private static final String PLAYER_PREFIX = "Player ";
    private static final String REMAINING_STACK = "Remaining";

    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new LinkedHashMap<>();
            stacks.put("Community", new ArrayList<>());
            for (int i = 1; i <= players; i++) {
                stacks.put(PLAYER_PREFIX + i, new ArrayList<>());
            }
            stacks.put(REMAINING_STACK, new ArrayList<>());

            // Deal cards to players
            for (int round = 1; round <= 2; round++) {
                for (int i = 1; i <= players; i++) {
                    Card card = deck.dealCard();
                    stacks.get(PLAYER_PREFIX + i).add(card);
                }
            }

            // Deal cards to community stack
            for (int i = 0; i < 5; i++) {
                Card card = deck.dealCard();
                stacks.get("Community").add(card);
            }

            // Deal remaining cards to the "Remaining" stack
            while (deck.size() > 0) {
                Card card = deck.dealCard();
                stacks.get(REMAINING_STACK).add(card);
            }

            return stacks;
        };
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new LinkedHashMap<>();
            for (int i = 1; i <= players; i++) {
                stacks.put(PLAYER_PREFIX + i, new ArrayList<>());
            }
            stacks.put(REMAINING_STACK, new ArrayList<>());

            // Deal cards to players
            for (int round = 1; round <= 5; round++) {
                for (int i = 1; i <= players; i++) {
                    Card card = deck.dealCard();
                    stacks.get(PLAYER_PREFIX + i).add(card);
                }
            }

            // Deal remaining cards to the "Remaining" stack
            while (deck.size() > 0) {
                Card card = deck.dealCard();
                stacks.get(REMAINING_STACK).add(card);
            }

            return stacks;
        };
    }

    public static CardDealingStrategy bridgeCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new LinkedHashMap<>();
            for (int i = 1; i <= players; i++) {
                stacks.put(PLAYER_PREFIX + i, new ArrayList<>());
            }
            stacks.put(REMAINING_STACK, new ArrayList<>());

            int cardsPerPlayer = 13;

            // Deal cards to players
            for (int round = 1; round <= cardsPerPlayer; round++) {
                for (int i = 1; i <= players; i++) {
                    Card card = deck.dealCard();
                    stacks.get(PLAYER_PREFIX + i).add(card);
                }
            }

            // Remove the "Remaining" stack if it's empty
            if (stacks.get(REMAINING_STACK).isEmpty()) {
                stacks.remove(REMAINING_STACK);
            }

            return stacks;
        };
    }

    public static CardDealingStrategy foolCardDealingStrategy() {
        return (deck, players) -> {
            Map<String, List<Card>> stacks = new LinkedHashMap<>();
            for (int i = 1; i <= players; i++) {
                stacks.put(PLAYER_PREFIX + i, new ArrayList<>());
            }
            stacks.put("Trump card", new ArrayList<>());
            stacks.put(REMAINING_STACK, new ArrayList<>());

            // Deal cards to players
            for (int round = 1; round <= 6; round++) {
                for (int i = 1; i <= players; i++) {
                    Card card = deck.dealCard();
                    stacks.get(PLAYER_PREFIX + i).add(card);
                }
            }

            // Deal a card to the "Trump card" stack
            Card trumpCard = deck.dealCard();
            stacks.get("Trump card").add(trumpCard);

            // Deal remaining cards to the "Remaining" stack
            while (deck.size() > 0) {
                Card card = deck.dealCard();
                stacks.get(REMAINING_STACK).add(card);
            }

            return stacks;
        };
    }
}
