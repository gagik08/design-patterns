package com.epam.rd.autocode.factory.plot;

import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;

public class ClassicDisneyPlot implements Plot {
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public ClassicDisneyPlot(Character hero, EpicCrisis epicCrisis, Character villain) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        return hero.name() + " is great. " + hero.name() + " and " + epicCrisis.name() +
                " love each other. " + villain.name() + " interferes with their happiness but loses in the end.";
    }
}
