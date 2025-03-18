package mineField;

import mvc.Command;
import mvc.Model;

public class Move extends Command {
    private Field field;
    private String direction;

    public Move(Model model, String direction) {
        super(model);
        this.field = (Field) model;
        this.direction = direction;
    }

    @Override
    public void execute() {
        if (field == null) {
            System.out.println("Error, field null");
            return;
        }
        field.movePlayer(direction);
    }

}
