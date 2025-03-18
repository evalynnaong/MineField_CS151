package mvc;

public abstract class Command extends Model{
    protected Model model;
    public Command(Model model) {}
    public abstract void execute();
    //public abstract void undo();
}
