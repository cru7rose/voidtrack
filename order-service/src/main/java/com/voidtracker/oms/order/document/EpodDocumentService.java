package com.voidtracker.oms.order.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EpodDocumentService {
    @Autowired
    private EpodDocumentRepository epodDocumentRepository;

    public void saveEpodDocument(EpodDocumentDto doc) {
        epodDocumentRepository.save(doc);
    }

    public List<EpodDocumentDto> getAllEpodDocuments() {
        return epodDocumentRepository.findAll();
    }
}
