package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables;

    public SearchEngine() {
        searchables = new HashSet<>();
    }

    public Set<Searchable> search(String search) {
        Set<Searchable> searchResult = new TreeSet<>(new SearchComparator());
        for (Searchable searchable : searchables) {
            if (searchable.searchTerm().contains(search)) {
                searchResult.add(searchable);
            }
        }
        return searchResult;
    }


    public void add(Searchable addItem) {
        searchables.add(addItem);
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
