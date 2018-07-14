package myWords;

public class CategoryKnowledge
{
    private String category;

    public CategoryKnowledge(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return category;
    }
}
