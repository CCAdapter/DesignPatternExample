package Command.ex1.drawer;

import Command.ex1.command.Command;

import java.awt.*;

public class ColorCommand implements Command {
    protected Drawable drawable;

    private Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.color = color;
        this.drawable = drawable;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
