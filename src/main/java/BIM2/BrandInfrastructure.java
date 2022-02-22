package BIM2;

import java.util.List;

public interface BrandInfrastructure {
    void indexBrandInfo();
    String[] tokenization(String delimiter, String ignore);

    List searchBrands();
}
