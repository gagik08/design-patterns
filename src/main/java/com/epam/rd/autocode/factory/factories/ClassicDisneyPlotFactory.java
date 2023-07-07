package com.epam.rd.autocode.factory.factories;

import com.epam.rd.autocode.factory.EpicCrisis;
import com.epam.rd.autocode.factory.Plot;
import com.epam.rd.autocode.factory.plot.Character;
import com.epam.rd.autocode.factory.plot.ClassicDisneyPlot;
import com.epam.rd.autocode.factory.plot.PlotFactory;

public class ClassicDisneyPlotFactory implements PlotFactory {
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character villain;

    public ClassicDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character villain) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        // Create and return a classic Disney plot based on the provided characters
        return new ClassicDisneyPlot(hero, epicCrisis, villain);
    }
}
