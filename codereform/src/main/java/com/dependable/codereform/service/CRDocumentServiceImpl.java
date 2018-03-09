package com.dependable.codereform.service;

import com.dependable.codereform.model.CRDocument;
import com.dependable.codereform.model.CRDocumentScore;
import com.dependable.codereform.service.contract.CRDocumentService;
import com.dependable.codereform.util.CRUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRDocumentServiceImpl implements CRDocumentService {
    private CRUtil util;

    @Autowired
    public CRDocumentServiceImpl(CRUtil util) {
        this.util = util;
    }

    @Override
    public CRDocumentScore calculateScore(CRDocument document) {
        CRDocumentScore resultScore = new CRDocumentScore();
        int lines = util.countLines(document);
        int totalOperators = util.countTotalOperators(document);
        int totalOperands = util.countTotalOperands(document);
        int distinctOperators = util.countDistinctOperators(document);
        int distinctOperands = util.countDistinctOperands(document);

        resultScore.setNumberLines(lines);
        resultScore.setVocabulary(distinctOperands + distinctOperators);
        resultScore.setLength(totalOperands + totalOperators);
        resultScore.setCalculatedLength(
                (int) (totalOperands * Math.log(totalOperands) + totalOperators * Math.log(totalOperators))
        );
        resultScore.setVolume(
                resultScore.getLength() * Math.log(resultScore.getVocabulary())
        );
        resultScore.setDifficulty(
                (distinctOperators / 2) * (totalOperands / distinctOperands)
        );
        resultScore.setEffort(resultScore.getDifficulty() * resultScore.getVolume());
        resultScore.setTimeRequiredToProgram(resultScore.getEffort() / 18);
        resultScore.setNumberDeliveredBugs(resultScore.getVolume() / 3000);

        System.out.println(resultScore);

        return resultScore;
    }
}
