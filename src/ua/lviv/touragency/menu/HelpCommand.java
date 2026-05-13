package ua.lviv.touragency.menu;

public class HelpCommand implements Command {

    @Override
    public String getName() {
        return "Довідка";
    }

    @Override
    public boolean execute() {
        System.out.println("Програма дозволяє завантажувати, фільтрувати, сортувати туристичні путівки.");
        return false;
    }
}
