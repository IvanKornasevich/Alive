package com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.direct;

import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.alive.bot.single.genome.gene.direct.Eat;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.GeneFactory;

public class EatGeneFactory implements GeneFactory {

    @Override
    public Gene create(int key, int genomeLength) {

        return new Eat();
    }
}
