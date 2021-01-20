package bounds;

import java.awt.*;

/**
 * @author denglitong
 * @date 2021/1/19
 */
interface HasColor {
    Color getColor();
}

class WithColor<T extends HasColor> {
    T item;

    public WithColor(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        // type bound allows you to call a method
        return item.getColor();
    }
}

class Coord {
    public int x;
    public int y;
    public int z;
}

// extends class first, then interface
class WithColorCoord<T extends Coord & HasColor> {
    T item;

    public WithColorCoord(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

// you can have only one concrete class but multiple interfaces
class Solid<T extends Coord & HasColor & Weight> {
    T item;

    public Solid(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int weight() {
        return item.weight();
    }
}

class Bounded extends Coord implements HasColor, Weight {
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
