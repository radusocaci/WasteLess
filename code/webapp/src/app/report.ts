export interface Report {
  nrItemsBought: number,
  totalCaloriesConsumed: number,
  totalCaloriesWasted: number,
  wastedGroceryItems: Map<string, number>
}
