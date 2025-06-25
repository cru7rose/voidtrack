package com.voidtracker.oms.order.document;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EpodDocumentRepository {
    private final Map<String, EpodDocumentDto> documents = new HashMap<>();

    public void save(EpodDocumentDto doc) { documents.put(doc.getDocumentId(), doc); }
    public Optional<EpodDocumentDto> findById(String documentId) { return Optional.ofNullable(documents.get(documentId)); }
    public List<EpodDocumentDto> findAll() { return new ArrayList<>(documents.values()); }
}
