package alive.entities.alive.bot.genome.gene.direct;

import alive.entities.alive.bot.Bot;
import alive.entities.alive.bot.BotAlive;
import alive.entities.alive.bot.direction.BotLookDirection;
import alive.entities.alive.bot.energy.EnergyAliveBot;
import alive.entities.alive.bot.genome.Genome;
import alive.entities.alive.bot.genome.gene.GeneTest;
import alive.entities.dead.DeadBotBody;
import alive.entities.dead.Empty;
import alive.entities.qualities.energy.EnergyEntity;
import alive.entities.qualities.position.PositionEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class EatTest extends GeneTest {

    public EatTest() {
        super(new Eat());
    }

    private Bot botSetup(int x, int y, int lookDirNum) {

        var bot = spy(new BotAlive(field, new PositionEntity(x, y), new EnergyAliveBot(0), new BotLookDirection(lookDirNum), mock(Genome.class)));
        return bot;
    }

    @Test
    public void eatingEraseEntityFromField() {

        var bot = botSetup(0, 0, 0);
        var lookPos = bot.getLookDirection().getLookingPos(bot.getPosition());

        cellMatrix.putEntity(new DeadBotBody(lookPos, new EnergyEntity(0)));
        gene.run(bot);
        Assertions.assertTrue(cellMatrix.isEmpty(lookPos));

        cellMatrix.putEntity(botSetup(2, 1, 0));
        gene.run(bot);
        Assertions.assertTrue(cellMatrix.isEmpty(lookPos));
    }

    @Test
    public void eatingIncreasesEnergyValue() {

        var bot = botSetup(0, 0, 0);
        var testEmpty = mock(Empty.class);

        when(testEmpty.getEnergy()).thenReturn(new EnergyEntity(100));

        cellMatrix.putEntity(bot);
        cellMatrix.putEntity(testEmpty);

        gene.run(bot);
        Assertions.assertTrue(bot.getEnergy().getEnergyValue() > 0);
    }
}