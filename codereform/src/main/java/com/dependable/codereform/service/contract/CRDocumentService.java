package com.dependable.codereform.service.contract;

import com.dependable.codereform.model.CRDocument;
import com.dependable.codereform.model.CRDocumentScore;

public interface CRDocumentService {
    CRDocumentScore calculateScore(CRDocument document);

    // TODO: 01/02/18 Add more methods:
}
