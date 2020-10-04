package com.wasteless.sd.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "groceryitem")
public class GroceryListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "grocerylist_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private GroceryList groceryList;

    @NotNull
    private String name;

    @NotNull
    private int quantity;

    @NotNull
    private int calorieValue;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date purchaseDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date consumptionDate;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalorieValue() {
        return calorieValue;
    }

    public void setCalorieValue(int calorieValue) {
        this.calorieValue = calorieValue;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "GroceryListItem{" +
                "id=" + id +
                ", groceryList=" + groceryList +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", calorieValue=" + calorieValue +
                ", purchaseDate=" + purchaseDate +
                ", consumptionDate=" + consumptionDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
