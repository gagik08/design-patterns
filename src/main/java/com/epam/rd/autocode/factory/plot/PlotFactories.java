package com.epam.rd.autocode.factory.plot;


public class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        return new ClassicDisneyPlotFactory(hero, beloved, villain);
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        return new ContemporaryDisneyPlotFactory(hero, epicCrisis, funnyFriend);
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {
        return new MarvelPlotFactory(heroes, epicCrisis, villain);
    }
}

class ClassicDisneyPlotFactory implements PlotFactory {
    private final Character hero;
    private final Character beloved;
    private final Character villain;

    public ClassicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public Plot plot() {
        return new ClassicDisneyPlot(hero, beloved, villain);
    }
}

class ContemporaryDisneyPlotFactory implements PlotFactory {
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
        return new ContemporaryDisneyPlot(hero, epicCrisis, funnyFriend);
    }
}

class MarvelPlotFactory implements PlotFactory {
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
        return new MarvelPlot(heroes, epicCrisis, villain);
    }
}

class ClassicDisneyPlot implements Plot {
    private final Character hero;
    private final Character beloved;
    private final Character villain;

    public ClassicDisneyPlot(Character hero, Character beloved, Character villain) {
        this.hero = hero;
        this.beloved = beloved;
        this.villain = villain;
    }

    @Override
    public String toString() {
        return hero.name() + " is great. " + hero.name() + " and " + beloved.name() +
                " love each other. " + villain.name() + " interferes with their happiness but loses in the end.";
    }
}

class ContemporaryDisneyPlot implements Plot {
    private final Character hero;
    private final EpicCrisis epicCrisis;
    private final Character funnyFriend;

    public ContemporaryDisneyPlot(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        this.hero = hero;
        this.epicCrisis = epicCrisis;
        this.funnyFriend = funnyFriend;
    }

    @Override
    public String toString() {
        return hero.name().trim() + " feels a bit awkward and uncomfortable. " +
                "But personal issues fades, when a big trouble comes - " + epicCrisis.name().trim() + ". " +
                hero.name().trim() + " stands up against it, but with no success at first." +
                "But putting self together and help of friends, including spectacular funny " +
                funnyFriend.name().trim() + " " +
                "restore the spirit and " + hero.name().trim() +
                " overcomes the crisis and gains gratitude and respect";
    }
}



class MarvelPlot implements Plot {
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

