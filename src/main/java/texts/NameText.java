package texts;

public class NameText
{
    private String name_text;

    NameText(String name_text) {
        this.name_text = name_text;
    }

    public String getName_text() {
        return name_text;
    }

    @Override
    public String toString() {
        return name_text;
    }
}
