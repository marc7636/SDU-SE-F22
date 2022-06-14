package dk.sdu.se_f22.sortingmodule.infrastructure.presentation;

import dk.sdu.se_f22.sharedlibrary.SearchHits;
import dk.sdu.se_f22.sharedlibrary.utils.ScoreSortType;
import dk.sdu.se_f22.sortingmodule.infrastructure.domain.SortingModule;
import dk.sdu.se_f22.sortingmodule.infrastructure.domain.SortingModuleImpl;

public class SortingModuleDemo {

    // To use mockdata, mark those below to true.
    private static boolean useMockDataBrands = true;
    private static boolean useMockDataContent = true;
    private static boolean useMockDataProducts = true;

    public static void main(String[] args) {
        SortingModule module = new SortingModuleImpl();

        // Use Mocked Data
        module.useMockData(useMockDataBrands, useMockDataContent, useMockDataProducts);

        // "search" method, before using below:
        module.setSearchString("Hello World!");
        module.addCategory(1);
        module.addCategory(3);
        module.addCategory(5);
        module.addRange(4, 2.46854, 3.89);
        module.setPagination(0, 5);
        module.setScoring(ScoreSortType.ALL);
        SearchHits data = module.search();

        // Data received
        System.out.println("Products: " + data.getProducts().toString());
        System.out.println("Brands: " + data.getBrands().toString());
        System.out.println("Content: " + data.getContents().toString());

    }
}
