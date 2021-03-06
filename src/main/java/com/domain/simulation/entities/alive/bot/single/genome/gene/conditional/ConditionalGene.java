package com.domain.simulation.entities.alive.bot.single.genome.gene.conditional;

import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;

public abstract class ConditionalGene implements Gene {

    /**
     * parameter for conditional jump
     */
    protected int key;

    /**
     * @param key Using as a parameter for conditional jump.
     */
    public ConditionalGene(int key) {

        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {

        return (obj.getClass() == this.getClass()) && ((ConditionalGene) obj).key == this.key;
    }

    @Override
    public String toString() {
        return "ConditionalGene{" +
                "key=" + key +
                '}';
    }
}
