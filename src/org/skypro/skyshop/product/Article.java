package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements Searchable {
    private String name;
    private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Название статьи: " + name + ", Текст статьи: " + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContentName() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
