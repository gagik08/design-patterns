package com.epam.rd.autocode.factory.factories;

import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;
import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.MarvelPlot;
import com.epam.rd.autocode.factory.plot.PlotFactory;

public class MarvelPlotFactory implements PlotFactory {
    private final Character[] heroes;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public MarvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        this.heroes = heroes;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        // Create and return a Marvel plot based on the provided characters, epic crisis, and villain
        return new MarvelPlot(heroes, epicCrisis, villain);
    }
}
