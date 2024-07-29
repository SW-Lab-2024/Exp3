package main.classes;

public class Book implements Searchable {
    private int id;
    private String title;
    private String author;

    public Book(String title, String author, int id) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }


    @Override
    public boolean matches(SearchByType searchByType, Object key) {
        switch (searchByType) {
            case ID:
                if (key instanceof Integer) {
                    return this.id == (Integer) key;
                }
                break;
            case TITLE:
                if (key instanceof String) {
                    return this.title.equals(key);
                }
                break;
            case AUTHOR:
                if (key instanceof String) {
                    return this.author.equals(key);
                }
                break;
        }
        throw new IllegalArgumentException();
    }
}