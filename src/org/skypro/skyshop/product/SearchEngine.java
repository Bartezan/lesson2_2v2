package org.skypro.skyshop.product;

import java.util.Objects;

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
            if (count == 5) {
                break;
            }
            if (searchable.searchTerm().contains(search)) {
                searchResult[count++] = searchable;
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

    public Searchable getBestSearch(String search) throws BestResultNotFound {
        Searchable[] searchResult = new Searchable[1];
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            int count = 0;
            int index = 0;
            int indexTemp = searchable.searchTerm().indexOf(search, index);
            if (indexTemp == -1) {
                continue;
            }
            while (indexTemp != -1) {
                count++;
                index = indexTemp + search.length();
                indexTemp = searchable.searchTerm().indexOf(search, index);
            }
            if (count > maxCount) {
                searchResult[0] = searchable;
            }
        }
        if (Objects.isNull(searchResult[0])) {
            throw new BestResultNotFound("Подходящий элемент по запросу (" + search + ") не найден");
        }
        return searchResult[0];
    }
}
