package tools;

interface Model {
}

interface View {
}

interface Command {
    void execute();
    void undo();
}



interface AppFactory {
    Model makeModel();
    View makeView();
    String getTitle();
    String getHelp();
    String about();
    String getEditCommands();
    Command makeEditCommand(String name);
}
