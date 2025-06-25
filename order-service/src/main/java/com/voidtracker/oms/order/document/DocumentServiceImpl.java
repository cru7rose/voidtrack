package com.voidtracker.oms.order.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentServiceImpl extends DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public void saveDocument(DocumentDto doc) {
        documentRepository.save(doc);
    }

    public List<DocumentDto> getAllDocuments() {
        return documentRepository.findAll();
    }
}
