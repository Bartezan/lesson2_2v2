package org.skypro.skyshop.product;

public interface Searchable {
    String searchTerm();

    String getContentName();

    default String getStringRepresentation() {
        return searchTerm() + ", " + getContentName();
    }
}