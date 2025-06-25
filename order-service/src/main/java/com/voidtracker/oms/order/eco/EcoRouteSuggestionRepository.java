package com.voidtracker.oms.order.eco;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EcoRouteSuggestionRepository {
    private final Map<String, EcoRouteSuggestionDto> suggestions = new HashMap<>();

    public void save(EcoRouteSuggestionDto suggestion) { suggestions.put(suggestion.getSuggestionId(), suggestion); }
    public Optional<EcoRouteSuggestionDto> findById(String suggestionId) { return Optional.ofNullable(suggestions.get(suggestionId)); }
    public List<EcoRouteSuggestionDto> findAll() { return new ArrayList<>(suggestions.values()); }
}
