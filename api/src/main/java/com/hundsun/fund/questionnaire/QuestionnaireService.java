package com.hundsun.fund.questionnaire;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;
import com.hundsun.fund.questionnaire.dto.QuestionnaireDTO;


import java.util.List;

@CloudService
public interface QuestionnaireService {
    // 创建一个新的问卷
    @CloudFunction("createQuestionnaire")
    Boolean createQuestionnaire(QuestionnaireDTO questionnaire);

    // 根据问卷ID删除问卷
    @CloudFunction("deleteQuestionnaire")
    Boolean deleteQuestionnaire(Long questionnaireId);

    // 更新一个现有的问卷
    @CloudFunction("updateQuestionnaire")
    Boolean updateQuestionnaire(Long questionnaireId, QuestionnaireDTO updatedQuestionnaire);

    // 获取前10个问卷的列表
    @CloudFunction("getTopQuestionnaires")
    List<QuestionnaireDTO> getTopQuestionnaires();

    // 获取接下来的10个问卷的列表
    @CloudFunction("getNextQuestionnaires")
    List<QuestionnaireDTO> getNextQuestionnaires(Long lastQuestionnaireId);
}
