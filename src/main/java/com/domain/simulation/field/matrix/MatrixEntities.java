package com.domain.simulation.field.matrix;

import com.domain.simulation.entities.Entity;
import com.domain.simulation.entities.alive.qualities.position.Position;
import com.domain.simulation.entities.lifeless.Empty;

import java.util.List;
import java.util.Optional;

public interface MatrixEntities {

    Optional<Position> createPositionInside(int x, int y);

    Optional<Position> makePositionToBeInside(Position pos);

    List<Position> findEmptyPositionsAround(Position pos);

    /**
     * @param pos position of a cell on the matrixEntities.
     * @return entity in the cell at the position.
     */
    Entity get(Position pos);

    /**
     * @param newEntity will be assigned to the cell at the position
     * @return the entity, which was in the position before putting.
     */
    Entity put(Entity newEntity);

    /**
     * Makes the position {@link Empty}
     *
     * @param pos position of a cell on matrixEntities.
     * @return the entity, which was in the position before pulling.
     * @see Entity
     * @see Empty
     */
    Entity pull(Position pos);


    /**
     * @param pos checking position on matrixEntities
     * @return <b>true</b> if the {@link Entity} in the position is instance of {@link Empty} and
     * <b>false</b> if not.
     * @see Entity
     * @see Empty
     */
    boolean isEmpty(Position pos);

    boolean isInMatrix(Entity entity);

    Entity[][] getEntities();

    int getWidth();

    int getHeight();
}
