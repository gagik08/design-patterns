package com.epam.rd.autocode.factory.factories;

import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;
import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.ContemporaryDisneyPlot;
import com.epam.rd.autocode.factory.plot.PlotFactory;

public class ContemporaryDisneyPlotFactory implements PlotFactory {
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    public ContemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public Plot plot() {
        // Create and return a contemporary Disney plot based on the provided characters and epic crisis
        return new ContemporaryDisneyPlot(hero, epicCrisis, funnyFriend);
    }
}
