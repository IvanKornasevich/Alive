package com.domain.simulation.entities.lifeless;

import com.domain.simulation.entities.alive.qualities.energy.Energy;
import com.domain.simulation.entities.alive.qualities.energy.EnergyEntity;
import com.domain.simulation.entities.alive.qualities.position.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class LifelessEntityTest {

    Energy energy = new EnergyEntity(200);
    LifelessEntity body = spy(new LifelessBotBody(mock(Position.class), energy));

    @Test
    void isAlive() {
        Assertions.assertFalse(body.isAlive());
    }

    @Test
    void getEnergy() {
        Assertions.assertEquals(energy, body.energy());
    }

    @Test
    void makeAMove() {
        Assertions.assertDoesNotThrow(() -> body.makeAMove());
    }
}