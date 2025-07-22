package org.skypro.skyshop.product;

public class SearchEngine {
    private Searchable[] searchables;
    private int count;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        count = 0;
    }

    public Searchable[] search(String search) {
        int count = 0;
        Searchable[] searchResult = new Searchable[5];
        for (Searchable searchable : searchables) {
            if (count == 5) break;
            if (searchable.searchTerm().contains(search)) {
                searchResult[count] = searchable;
                count++;
            }
        }
        return searchResult;
    }

    public void add(Searchable addItem) {
        if (count == searchables.length) {
            System.out.println("Превышено количество объектов в поисковом движке");
            return;
        }
        searchables[count++] = addItem;
    }
}
