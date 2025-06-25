package com.voidtracker.oms.order.eco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/eco/route-suggestions")
public class EcoRouteSuggestionController {
    @Autowired
    private EcoRouteSuggestionService ecoRouteSuggestionService;

    @GetMapping
    public List<EcoRouteSuggestionDto> getAllSuggestions() {
        return ecoRouteSuggestionService.getAllSuggestions();
    }
}
