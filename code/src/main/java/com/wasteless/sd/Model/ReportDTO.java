package com.wasteless.sd.Model;

import java.util.Map;

public class ReportDTO {
    public static class ReportBuilder {
        private int nrItemsBought;
        private int totalCaloriesConsumed;
        private int totalCaloriesWasted;
        private Map<String, Integer> wastedGroceryItems;

        public ReportBuilder() {

        }

        public ReportDTO build() {
            return new ReportDTO(this);
        }

        public ReportBuilder withNrItemsBought(int nrItemsBought) {
            this.nrItemsBought = nrItemsBought;
            return this;
        }

        public ReportBuilder withTotalCaloriesConsumed(int totalCaloriesConsumed) {
            this.totalCaloriesConsumed = totalCaloriesConsumed;
            return this;
        }

        public ReportBuilder withTotalCaloriesWasted(int totalCaloriesWasted) {
            this.totalCaloriesWasted = totalCaloriesWasted;
            return this;
        }

        public ReportBuilder withWastedGroceryItems(Map<String, Integer> wastedGroceryItems) {
            this.wastedGroceryItems = wastedGroceryItems;
            return this;
        }
    }

    private int nrItemsBought;
    private int totalCaloriesConsumed;
    private int totalCaloriesWasted;
    private Map<String, Integer> wastedGroceryItems;

    public ReportDTO(ReportBuilder builder) {
        nrItemsBought = builder.nrItemsBought;
        totalCaloriesConsumed = builder.totalCaloriesConsumed;
        totalCaloriesWasted = builder.totalCaloriesWasted;
        wastedGroceryItems = builder.wastedGroceryItems;
    }

    public int getNrItemsBought() {
        return nrItemsBought;
    }

    public int getTotalCaloriesConsumed() {
        return totalCaloriesConsumed;
    }

    public int getTotalCaloriesWasted() {
        return totalCaloriesWasted;
    }

    public Map<String, Integer> getWastedGroceryItems() {
        return wastedGroceryItems;
    }
}
