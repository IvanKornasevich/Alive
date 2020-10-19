package alive.bot.position;

import alive.field.Field;

import java.util.ArrayList;
import java.util.List;

public class BotPosition implements Position {

    private int x;
    private int y;

    public BotPosition(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {

        return x;
    }

    @Override
    public int getY() {

        return y;
    }

    @Override
    public List<Position> getPositionsAround(Field field) {

        var positionsAround = new ArrayList<Position>(8);

        for (var i = getX() - 1; i <= getX() + 1; ++i) {
            for (var j = getY() - 1; j <= getY() + 1; ++j) {
                if (getY() > 0 && getY() < field.getWidth()) {
                    if (i != getX() || j != getY()) {
                        var newPosition = new BotPosition((i + field.getWidth()) % field.getWidth(), j);
                        positionsAround.add(newPosition);
                    }
                }
            }
        }

        return positionsAround;
    }
}