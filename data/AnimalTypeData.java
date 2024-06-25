package data;

public enum AnimalTypeData implements IData {

    CAT("кот"),
    DOG("собака"),
    DUCK("утка");

    private String name;

    AnimalTypeData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
