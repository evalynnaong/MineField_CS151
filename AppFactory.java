package tools;


interface Command {
    void execute();
    void undo();
}



public interface AppFactory {
    Model makeModel();
    View makeView();
    String getTitle();
    String getHelp();
    String about();
    String getEditCommands();
    Command makeEditCommand(String name);
}
