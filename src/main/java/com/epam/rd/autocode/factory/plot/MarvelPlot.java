package com.epam.rd.autocode.factory.plot;

import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;

public class MarvelPlot implements Plot {
    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlot(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(epicCrisis.name().trim()).append(" threatens the world. ");
        builder.append("But ");

        for (int i = 0; i < heroes.length; i++) {
            builder.append("brave ").append(heroes[i].name().trim());
            if (i <= heroes.length - 2) {
                builder.append(", ");
            } else if (i == heroes.length - 2) {
                builder.append(" and ");
            }
        }

        builder.append(" on guard. So, no way that intrigues of ").append(villain.name().trim());
        builder.append(" overcome the willpower of inflexible heroes");
        return builder.toString();
    }
}