package com.hundsun.fund.service;


import com.hundsun.fund.questionnaire.QuestionnaireService;
import com.hundsun.fund.questionnaire.dto.QuestionnaireDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.fund.mapper.QuestionnaireMapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CloudComponent
public class QuestionnaireServiceImpl implements QuestionnaireService {
    private static final Logger log = LoggerFactory.getLogger(QuestionnaireServiceImpl.class);
    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Override
    public Boolean createQuestionnaire(QuestionnaireDTO questionnaire) {
        // 这里应该包含将新问卷保存到数据库的逻辑
        return questionnaireMapper.insertQuestionnaire(questionnaire) > 0;
    }

    @Override
    public Boolean deleteQuestionnaire(Long questionnaireId) {
        return questionnaireMapper.deleteQuestionnaireById(questionnaireId) > 0;
    }

    @Override
    public Boolean updateQuestionnaire(@Param("questionnaireId")Long questionnaireId, @Param("questionnaire") QuestionnaireDTO updatedQuestionnaire) {
        return questionnaireMapper.updateQuestionnaireById(questionnaireId, updatedQuestionnaire) > 0;
    }

    @Override
    public List<QuestionnaireDTO> getTopQuestionnaires() {

        return questionnaireMapper.selectTop10Questionnaires();
    }

    @Override
    public List<QuestionnaireDTO> getNextQuestionnaires(Long lastQuestionnaireId) {

        return questionnaireMapper.getNextTenQuestionnaires(lastQuestionnaireId);
    }

    @Override
    public List<QuestionnaireDTO> getAllQuestionnaires() {
        log.info("------------------------");
        List<QuestionnaireDTO> a = questionnaireMapper.selectAllQuestionnaires();
        log.info(a.toString());
        return questionnaireMapper.selectAllQuestionnaires();
    }


}
