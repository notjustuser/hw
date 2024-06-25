package data;

public enum ColorData implements IData {

    YELLOW("жёлтый"),
    BLACK("чёрный"),
    GREY("серый"),
    WHITE("белый");

    private String name;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
