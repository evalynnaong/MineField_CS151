package MineField;

import tools.Command;

public class Move extends Command {
    private Field field;
    private String direction;

    public Move(Field field, String direction) {
        this.field = field;
        this.direction = direction;
    }

    @Override
    public void execute() {
        field.move(direction);
    }

    @Override
    public void undo() {
        // nah don't implement, that's cheating
    }

}
