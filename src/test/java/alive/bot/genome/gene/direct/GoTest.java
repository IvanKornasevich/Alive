package alive.bot.genome.gene.direct;

import alive.bot.direction.look.BotLookDirection;
import alive.bot.energy.BotEnergy;
import alive.bot.energy.EntityEnergy;
import alive.bot.genome.Genome;
import alive.bot.genome.gene.GeneTest;
import alive.bot.model.AliveBot;
import alive.bot.model.Bot;
import alive.bot.position.EntityPosition;
import alive.field.cells.content.DeadBotBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GoTest extends GeneTest {


    public GoTest() {
        super(new Go());
    }

    private void setup(int x, int y, int lookDirNum) {

        bot = spy(new AliveBot(field, new EntityPosition(x, y), 0, new BotLookDirection(lookDirNum), mock(Genome.class)));
        field.getCellsMatrix().addEntity(bot);
        when(bot.getEnergy()).thenReturn(mock(BotEnergy.class));
    }


    @Test
    public void isGoingRight() {

        setup(1, 1, 0);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(2, 1), bot.getPosition());
    }

    @Test
    public void isGoingUpRight() {

        setup(1, 1, 1);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(2, 2), bot.getPosition());
    }

    @Test
    public void isGoingUp() {

        setup(0, 0, 2);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(0, 1), bot.getPosition());
    }

    @Test
    public void isGoingUpLeft() {

        setup(1, 1, 3);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(0, 2), bot.getPosition());
    }

    @Test
    public void isGoingLeft() {

        setup(1, 1, 4);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(0, 1), bot.getPosition());
    }

    @Test
    public void isGoingDownLeft() {

        setup(1, 1, 5);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(0, 0), bot.getPosition());
    }

    @Test
    public void isGoingDown() {

        setup(1, 1, 6);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(1, 0), bot.getPosition());
    }

    @Test
    public void isGoingDownRight() {

        setup(1, 1, 7);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(2, 0), bot.getPosition());
    }


    @Test
    public void fieldTopLimitsBlockGoing() {

        setup(2, 2, 1);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(2, 2), bot.getPosition());
    }

    @Test
    public void fieldBottomLimitsBlockGoing() {

        setup(0, 0, 5);

        gene.run(bot);

        Assertions.assertEquals(new EntityPosition(0, 0), bot.getPosition());
    }

    @Test
    public void entitiesBlockGoing() {

        setup(1, 1, 0);

        cellsMatrix.addEntity(new DeadBotBody(new EntityPosition(2, 1), new EntityEnergy(0)));
        gene.run(bot);
        Assertions.assertEquals(new EntityPosition(1, 1), bot.getPosition());

        var botMock = mock(Bot.class);
        when(botMock.getPosition()).thenReturn(new EntityPosition(2, 1));
        cellsMatrix.addEntity(botMock);
        gene.run(bot);
        Assertions.assertEquals(new EntityPosition(1, 1), bot.getPosition());
    }
}