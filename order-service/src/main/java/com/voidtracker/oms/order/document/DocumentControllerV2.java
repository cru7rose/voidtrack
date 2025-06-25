package com.voidtracker.oms.order.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/documents")
public class DocumentControllerV2 {
    @Autowired
    private DocumentService documentService;

    @GetMapping
    public List<DocumentDto> getAllDocuments() {
        return documentService.getAllDocuments();
    }
}
