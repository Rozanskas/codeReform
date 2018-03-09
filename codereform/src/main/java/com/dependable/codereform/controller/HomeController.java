package com.dependable.codereform.controller;

import com.dependable.codereform.model.CRDocument;
import com.dependable.codereform.model.CRDocumentScore;
import com.dependable.codereform.service.contract.CRDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HomeController {
    private final CRDocumentService documentService;

    @Autowired
    public HomeController(CRDocumentService documentService) {
        this.documentService = documentService;
    }

    @CrossOrigin
    @PostMapping("/analyze")
    public CRDocumentScore getDocumentScore(@RequestBody CRDocument document) {
        return this.documentService.calculateScore(document);
    }
}
