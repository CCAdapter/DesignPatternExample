package Command.ex1.drawer;

import java.awt.*;

public class ColorCommand extends DrawCommand {
    private String color;

    public ColorCommand(Drawable drawable, Point position) {
        super(drawable, position);
    }
}
