package data;

public enum CommandsData implements IData {
    ADD("добавить"),
    LIST("перечислить"),
    EXIT("выйти");

    private String name;

    CommandsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
