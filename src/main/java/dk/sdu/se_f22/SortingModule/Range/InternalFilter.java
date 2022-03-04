package dk.sdu.se_f22.SortingModule.Range;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class InternalFilter {
    private final double min;
    private final double max;
    private final String productAttribute;

    public InternalFilter(double min, double max, String productAttribute) {
        this.min = min;
        this.max = max;
        this.productAttribute = productAttribute;
    }

    public RangeSearchResultMock[] useFilter(RangeSearchResultMock[] inputs) {
        // Filter inputs based on min and max value.
        // Only filter and remove the input if it is below min or above max
        List<RangeSearchResultMock> filteredResults = new ArrayList<>();
        for (RangeSearchResultMock searchResultMock : inputs) {
            //assumes that searchResultMock.getAttributes returns a hashmap of attributes where the keys are the names of the attributes
            //assumes that hashmaps return null when key is not found
            //if it returns an Exception instead, then simply add the product to filteredResults
            try {
                double attributeValue = searchResultMock.getAttributes().get(this.productAttribute);
                if ((attributeValue < this.min || attributeValue > this.max)) {
                    continue;
                }//guard clause
            } catch (NullPointerException e) {
                //if the product attribute does not exist, simply add the result to the list below.
                // if this behaviour is desired to change uncomment the line below:
                //continue;
            }

            filteredResults.add(searchResultMock);
        }

        return convertListToArray(filteredResults);
    }

    public static RangeSearchResultMock[] convertListToArray(List<RangeSearchResultMock> input){
        RangeSearchResultMock[] out = new RangeSearchResultMock[input.size()];

        for (int i =0; i< input.size(); i++) {
            out[i] = input.get(i);
        }
        return out;
    }
}
