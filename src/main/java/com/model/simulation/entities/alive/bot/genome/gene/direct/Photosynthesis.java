package com.model.simulation.entities.alive.bot.genome.gene.direct;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.gene.Gene;

public class Photosynthesis extends DirectGene {

    @Override
    public Boolean run(Bot bot) {

        bot.getEnergy().incrementEnergyValue(27);
        bot.getGenome().incrementGeneIdx(1);
        bot.getColor().incrementColor(-25, 50, -25);
        return false;
    }

    @Override
    public Gene replicate() {

        return new Photosynthesis();
    }
}