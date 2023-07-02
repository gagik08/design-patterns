package com.epam.rd.autocode.factory.plot;


import com.epam.rd.autocode.factory.factories.ClassicDisneyPlotFactory;
import com.epam.rd.autocode.factory.factories.ContemporaryDisneyPlotFactory;
import com.epam.rd.autocode.factory.factories.MarvelPlotFactory;
import com.epam.rd.autocode.factory.factories.PlotFactory;

public class PlotFactories {
    public PlotFactory classicDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character villain) {
        return new ClassicDisneyPlotFactory(hero, epicCrisis, villain);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return new ContemporaryDisneyPlotFactory(hero, epicCrisis, funnyFriend);
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return new MarvelPlotFactory(heroes, epicCrisis, villain);
    }
}