package com.wasteless.sd.Model;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Report {
    protected List<GroceryListItem> getItemsByPurchaseDate(List<GroceryListItem> groceryItems, int days) {
        return groceryItems.stream()
                .filter(item -> item.getPurchaseDate().after(Date.from(ZonedDateTime.now().minusDays(days).toInstant())))
                .collect(Collectors.toList());
    }

    protected ReportDTO toReport(List<GroceryListItem> groceryItems) {
        List<String> consumedItems = new ArrayList<>();
        int totalCalories = 0, consumedCalories = 0;

        for (GroceryListItem groceryListItem : groceryItems) {
            totalCalories += groceryListItem.getCalorieValue() * groceryListItem.getQuantity();

            if (groceryListItem.getConsumptionDate() != null
                    && groceryListItem.getConsumptionDate().before(Date.from(ZonedDateTime.now().toInstant()))) {
                consumedCalories += groceryListItem.getCalorieValue() * groceryListItem.getQuantity();
                consumedItems.add(groceryListItem.getName());
            }
        }

        Map<String, Integer> wastedGroceryItems = groceryItems.stream()
                .filter(item -> !consumedItems.contains(item.getName()))
                .collect(Collectors.groupingBy(GroceryListItem::getName, Collectors.summingInt(GroceryListItem::getQuantity)));

        return new ReportDTO.ReportBuilder()
                .withNrItemsBought(groceryItems.size())
                .withTotalCaloriesConsumed(totalCalories)
                .withTotalCaloriesWasted(totalCalories - consumedCalories)
                .withWastedGroceryItems(wastedGroceryItems)
                .build();
    }

    public abstract ReportDTO generateReport(List<GroceryListItem> groceryItems);
}
