package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchEngine {
    private List<Searchable> searchables;

    public SearchEngine() {
        searchables = new ArrayList<>();
    }

    public List<Searchable> search(String search) {
        int count = 0;
        List<Searchable> searchResult = new ArrayList<>();
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
