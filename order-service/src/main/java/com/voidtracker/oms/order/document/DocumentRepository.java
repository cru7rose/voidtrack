package com.voidtracker.oms.order.document;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class DocumentRepository {
    private final Map<String, DocumentDto> documents = new HashMap<>();

    public void save(DocumentDto doc) { documents.put(doc.getId(), doc); }
    public Optional<DocumentDto> findById(String id) { return Optional.ofNullable(documents.get(id)); }
    public List<DocumentDto> findAll() { return new ArrayList<>(documents.values()); }
}
