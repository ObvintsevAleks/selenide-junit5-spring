package autotest.ui.navisale.test.data;

import java.util.List;

public class TestData {

    public List<List<String>> getTestData() {
        List<String> querySalesRepName = List.of("Jane", "Ashish", "John");
        List<String> queryYear = List.of("2012", "2011", "2013");
        List<String> querySalesRepId = List.of("456", "789", "123");
        List<String> someExcelPostCodes = List.of("2044", "2165", "2039", "2140", "2122", "2152", "2096", "2031", "2011", "2094", "2111");
        return List.of(querySalesRepName, queryYear, querySalesRepId, someExcelPostCodes);
    }

}
