package Command.command;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class MacroCommand implements Command {
    private Deque<Command> commands = new LinkedList<>();

    @Override
    public void execute() {
        Iterator<Command> it = commands.iterator();
        while (it.hasNext()) {
            Command command = it.next();
            command.execute();
        }
    }

    public void append(Command cmd) {
        if (cmd != this) {
            commands.push(cmd);
        }
    }

    // 删除最后一条命令
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop();
        }
    }

    public void clear() {
        commands.clear();
    }
}
