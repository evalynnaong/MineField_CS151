package MineField;

import tools.AppFactory;
import tools.Command;
import tools.Model;
import tools.View;

public class FieldFactory implements AppFactory {

    public Model makeModel() {
        return null;
    }

    public View makeView() {
        return null;
    }

    public String getTitle() {
        return "";
    }

    public String getHelp() {
        return "";
    }

    public String about() {
        return "";
    }

    public String getEditCommands() {
        return "";
    }

    public Command makeEditCommand(String name) {
        return null;
    }
}
