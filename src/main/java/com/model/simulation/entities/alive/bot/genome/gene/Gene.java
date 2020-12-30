package com.model.simulation.entities.alive.bot.genome.gene;

import com.model.simulation.entities.alive.bot.Bot;
import com.model.simulation.entities.alive.bot.genome.Replicable;

public interface Gene extends Replicable<Gene> {

    /**
     * Runs current gen. This method <b>must</b> call {@link com.model.simulation.entities.alive.bot.genome.Genome#incrementGeneIdx(int)}
     *
     * @param bot current bot
     * @return if the command ends the turn returns <b>true</b>
     * else returns <b>false</b>
     */
    Boolean run(Bot bot);

    /**
     * If bots differ in one gen only they will be friendly.
     *
     * @param obj another gen
     * @return result of genes comparison
     */
    boolean equals(Object obj);
}