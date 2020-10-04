package com.wasteless.sd.Service.query;

import com.wasteless.sd.Factory.FactoryProvider;
import com.wasteless.sd.Model.GroceryListItem;
import com.wasteless.sd.Model.ReportDTO;
import com.wasteless.sd.Model.ReportType;
import com.wasteless.sd.Repository.GroceryItemRepository;
import com.wasteless.sd.Repository.GroceryListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportQueryService {
    private final GroceryListRepository groceryListRepository;
    private final GroceryItemRepository groceryItemRepository;

    public ReportQueryService(GroceryListRepository groceryListRepository,
                              GroceryItemRepository groceryItemRepository) {
        this.groceryListRepository = groceryListRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    public ReportDTO getReport(ReportType reportType, String username) {
        List<GroceryListItem> groceryItems = groceryListRepository.findAllByUsername(username)
                .stream()
                .map(list -> groceryItemRepository.findByGroceryListId(list.getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return FactoryProvider.getFactory(reportType)
                .getInstance(reportType)
                .generateReport(groceryItems);
    }
}
