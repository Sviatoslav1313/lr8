package ua.lviv.touragency.menu;

public class ExitCommand implements Command {

    @Override
    public String getName() {
        return "Вихід";
    }

    @Override
    public boolean execute() {
        return true;
    }
}
