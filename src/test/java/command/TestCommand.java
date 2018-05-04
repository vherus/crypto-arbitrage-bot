package command;

public class TestCommand implements Command {
    private String name;

    public TestCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
