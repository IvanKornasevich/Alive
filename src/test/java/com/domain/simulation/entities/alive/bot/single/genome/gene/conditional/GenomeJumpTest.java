package com.domain.simulation.entities.alive.bot.single.genome.gene.conditional;

import com.domain.simulation.entities.alive.bot.single.genome.GenomeBot;
import com.domain.simulation.entities.alive.bot.single.genome.gene.Gene;
import com.domain.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.conditional.GenomeJumpFactory;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class GenomeJumpTest extends GeneTest {

    public GenomeJumpTest() {
        super(new GenomeJumpFactory().create(5, 10));
    }

    @Test
    public void changesGeneIdxRight() {

        var genes = new Gene[]{
                mock(Gene.class),
                mock(Gene.class),
                mock(Gene.class),
        };

        var genome = new GenomeBot(genes);
        when(botMock.genome()).thenReturn(genome);

        gene = new GenomeJump(3);
        gene.run(botMock);

        genome.runCurrentGene(botMock);
        verify(genes[0]).run(botMock);

        gene = new GenomeJump(1);

        gene.run(botMock);
        genome.runCurrentGene(botMock);
        verify(genes[1]).run(botMock);

        gene.run(botMock);
        genome.runCurrentGene(botMock);
        verify(genes[2]).run(botMock);
    }
}