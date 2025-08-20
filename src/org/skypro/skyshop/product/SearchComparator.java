package org.skypro.skyshop.product;

import java.util.Comparator;

public class SearchComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
            int temp;
            temp = Integer.compare(o1.getContentName().length(), o2.getContentName().length());
            if (temp == 0) {
                return o1.getContentName().compareTo(o2.getContentName());
            }
            return temp;
    }
}
