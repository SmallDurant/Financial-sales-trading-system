package com.hundsun.mapper;

import com.hundsun.fund.questionnaire.dto.QuestionnaireDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@Mapper
public interface QuestionnaireMapper {

    // 插入一个新的问卷
    int insertQuestionnaire(QuestionnaireDTO questionnaire);

    // 根据问卷ID删除问卷
    int deleteQuestionnaireById(Long questionnaireId);

    // 更新一个现有的问卷
    int updateQuestionnaireById(@Param("questionnaireId") Long questionnaireId, @Param("questionnaire") QuestionnaireDTO updatedQuestionnaire);

    // 获取前10个问卷的列表
    List<QuestionnaireDTO> selectTop10Questionnaires();

    //获取接下来的10个问卷
    List<QuestionnaireDTO> getNextTenQuestionnaires(@Param("lastQuestionnaireId") long lastQuestionnaireId);
}

