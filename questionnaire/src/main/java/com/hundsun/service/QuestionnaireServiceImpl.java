package com.hundsun.service;


import com.hundsun.fund.questionnaire.QuestionnaireService;
import com.hundsun.fund.questionnaire.dto.QuestionnaireDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import com.hundsun.mapper.QuestionnaireMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CloudComponent
public class QuestionnaireServiceImpl implements QuestionnaireService {
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



}
