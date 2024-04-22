package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    Book(){
        id = 0;
        isbn = "Unknown";
        title = "Default Title";
        isCheckedOut = false;
        checkedOutTo = "No One";
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }


    public String getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return title;
    }


    public boolean isCheckedOut(boolean b) {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id);
        sb.append(", ISBN: '").append(isbn).append('\'');
        sb.append(", Title: '").append(title).append('\'');
        sb.append(", Checked Out: ").append(isCheckedOut);
        sb.append(", Checked Out To: '").append(checkedOutTo).append('\'');
        return sb.toString();
    }
}