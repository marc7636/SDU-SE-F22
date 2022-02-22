package BIM2;

import java.util.List;

public interface BrandInfrastructure {
    List<Brand> getBrandsFromSearchTokens(List<String> tokens);
    
    void indexBrands(List<Brand> brands);
    
    void setTokenizationParameters(String delimiter, String ignore);
}
