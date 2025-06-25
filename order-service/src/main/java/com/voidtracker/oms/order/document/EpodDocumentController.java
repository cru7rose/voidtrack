package com.voidtracker.oms.order.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/documents/epod")
public class EpodDocumentController {
    @Autowired
    private EpodDocumentService epodDocumentService;

    @GetMapping
    public List<EpodDocumentDto> getAllEpodDocuments() {
        return epodDocumentService.getAllEpodDocuments();
    }
}
