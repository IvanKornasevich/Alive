package com.domain.simulation.entities.alive.bot.single.genome.gene.conditional;

import com.domain.simulation.entities.alive.bot.single.genome.gene.GeneTest;
import com.domain.simulation.entities.alive.bot.single.genome.mutator.factory.conditional.RotatingGeneFactory;
import com.domain.simulation.entities.alive.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotatingTest extends GeneTest {

    public RotatingTest() {
        super(new RotatingGeneFactory().create(2, 0));
    }

    @Test
    public void noRotation() {

        setup(0);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(2, 1), botSpy.observedPos().orElseThrow());
    }

    private void setup(int geneArg) {

        gene = new Rotating(geneArg);
    }

    @Test
    public void rotateLeft1Step() {

        setup(-1);

        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(2, 0), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 0), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(0, 0), botSpy.observedPos().orElseThrow());
    }

    @Test
    public void rotateLeft2Steps() {

        setup(-2);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 0), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(0, 1), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 2), botSpy.observedPos().orElseThrow());
    }

    @Test
    public void rotateLeft3Steps() {

        setup(-3);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(0, 0), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 2), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(2, 0), botSpy.observedPos().orElseThrow());
    }

    @Test
    public void rotateRight1Step() {

        setup(1);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(2, 2), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 2), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(0, 2), botSpy.observedPos().orElseThrow());
    }

    @Test
    public void rotateRight2Steps() {

        setup(2);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 2), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(0, 1), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 0), botSpy.observedPos().orElseThrow());
    }

    @Test
    public void rotateRight3Steps() {

        setup(3);
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(0, 2), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(1, 0), botSpy.observedPos().orElseThrow());
        gene.run(botSpy);
        Assertions.assertEquals(new PositionEntity(2, 2), botSpy.observedPos().orElseThrow());
    }
}