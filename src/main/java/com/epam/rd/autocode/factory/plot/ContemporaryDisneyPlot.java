package com.epam.rd.autocode.factory.plot;

import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;

public class ContemporaryDisneyPlot implements Plot {
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public ContemporaryDisneyPlot(Character hero, EpicCrisis epicCrisis, Character villain) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public String toString() {
        return hero.name().trim() + " feels a bit awkward and uncomfortable. " +
                "But personal issues fades, when a big trouble comes - " + epicCrisis.name().trim() + ". " +
                hero.name().trim() + " stands up against it, but with no success at first." +
                "But putting self together and help of friends, including spectacular funny " +
                villain.name().trim() + " " +
                "restore the spirit and " + hero.name().trim() +
                " overcomes the crisis and gains gratitude and respect";
    }
}
