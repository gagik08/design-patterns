package com.epam.rd.autocode.startegy.cards.strategies;

import com.epam.rd.autocode.startegy.cards.Card;
import com.epam.rd.autocode.startegy.cards.Deck;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TexasHoldemCardDealingStrategy implements CardDealingStrategy {

    //    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
//        return (deck, players) -> {
//            Map<String, List<Card>> stacks = new LinkedHashMap<>();
//            stacks.put("Community", new ArrayList<>());
//            for (int i = 1; i <= players; i++) {
//                stacks.put(PLAYER_PREFIX + i, new ArrayList<>());
//            }
//            stacks.put(REMAINING_STACK, new ArrayList<>());
//
//            // Deal cards to players
//            for (int round = 1; round <= 2; round++) {
//                for (int i = 1; i <= players; i++) {
//                    Card card = deck.dealCard();
//                    stacks.get(PLAYER_PREFIX + i).add(card);
//                }
//            }
//
//            // Deal cards to community stack
//            for (int i = 0; i < 5; i++) {
//                Card card = deck.dealCard();
//                stacks.get("Community").add(card);
//            }
//
//            // Deal remaining cards to the "Remaining" stack
//            while (deck.size() > 0) {
//                Card card = deck.dealCard();
//                stacks.get(REMAINING_STACK).add(card);
//            }
//
//            return stacks;
//        };
    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> stacks = new LinkedHashMap<>();
        stacks.put("Community", new ArrayList<>());
        for (int i = 1; i <= players; i++) {
            stacks.put("Player " + i, new ArrayList<>());
        }
        stacks.put("Remaining", new ArrayList<>());

        // Deal cards to players
        for (int round = 1; round <= 2; round++) {
            for (int i = 1; i <= players; i++) {
                Card card = deck.dealCard();
                stacks.get("Player " + i).add(card);
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
            stacks.get("Remaining").add(card);
        }

        return stacks;
    }
}

