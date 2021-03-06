package com.domain.simulation.entities.alive.bot.single.genome.gene;

import com.domain.simulation.entities.alive.Replicable;
import com.domain.simulation.entities.alive.bot.Bot;

public interface Gene extends Replicable<Gene> {

    /**
     * Runs current gen. This method <b>must</b> call {@link com.domain.simulation.entities.alive.bot.single.genome.Genome#incrementGeneIdx(int)}
     *
     * @param bot current bot
     * @return if the command ends the turn returns <b>true</b>
     * else returns <b>false</b>
     */
    boolean run(Bot bot);

    /**
     * If bots differ in one gen only they will be friendly.
     *
     * @param obj another gen
     * @return result of genes comparison
     */
    boolean equals(Object obj);
}
