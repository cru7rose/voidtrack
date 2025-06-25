package com.voidtracker.oms.order.eco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EcoRouteSuggestionService {
    @Autowired
    private EcoRouteSuggestionRepository ecoRouteSuggestionRepository;

    public void saveSuggestion(EcoRouteSuggestionDto suggestion) {
        ecoRouteSuggestionRepository.save(suggestion);
    }

    public List<EcoRouteSuggestionDto> getAllSuggestions() {
        return ecoRouteSuggestionRepository.findAll();
    }
}
