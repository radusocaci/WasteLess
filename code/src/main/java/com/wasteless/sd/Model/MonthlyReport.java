package com.wasteless.sd.Model;

import java.util.List;

public class MonthlyReport extends Report {
    @Override
    public ReportDTO generateReport(List<GroceryListItem> groceryItems) {
        return toReport(getItemsByPurchaseDate(groceryItems, 30));
    }
}
