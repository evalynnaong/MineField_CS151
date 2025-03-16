package mineField;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class FieldFactory implements AppFactory {

    public Model makeModel() {
        return new Field();
    }

    public View makeView(Model m) {
        return new FieldView((Field) m);
    }

    public FieldView makeView(Field m) {
        return new FieldView(m);
    }

    public String getTitle() {
        return "Mine Field Game";
    }

    public String getHelp() {
        return "Click direction buttons to navigate Mine Field \n" +
                "Try to avoid mines";
    }

    public String about() {
        return "Mine Field Game version 1.0. Copyright 2025 Group 6";
    }

    public String[] getEditCommands() {
        return new String[] {"N", "S", "E", "W", "NE", "NW", "SE", "SW"};
    }

    public Command makeEditCommand(Model field, String direction) { //needs work
        return new Move((Field) field, direction);
    }
}
