package sample;

public class Book {
    public int id;
    public String name;
    public int authorID;
    public String description;
    public String pages;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getDescription() {
        return description;
    }

    public String getPages() {
        return pages;
    }

    public Book(int id, String name, int authorID, String description, String pages) {
        this.id = id;
        this.name = name;
        this.authorID = authorID;
        this.description = description;
        this.pages = pages;
    }
}
