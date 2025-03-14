package tools;

public interface AppFactory {
    Model makeModel();
    View makeView(Model m);
    String getTitle();
    String getHelp();
    String about();
    String[] getEditCommands();
    Command makeEditCommand(Model m, String name);
}
