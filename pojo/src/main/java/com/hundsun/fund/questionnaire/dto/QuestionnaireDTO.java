package com.hundsun.fund.questionnaire.dto;



import lombok.Data;

import java.io.Serializable;
@Data
public class QuestionnaireDTO implements Serializable {

    // 问题ID，对应于question_id字段
    private Long questionId;

    // 题干，对应于stem字段
    private String stem;

    // 选项，对应于option字段
    private String option;

    // 选项分数占比，对应于percent字段
    private String percent;

    // 逻辑删除标志，对应于is_delete字段
    private Boolean isDelete;

    // 省略了构造器、getter和setter方法...

    // Getter 方法
    public Long getQuestionId() {
        return questionId;
    }

    public String getStem() {
        return stem;
    }

    public String getOption() {
        return option;
    }

    public String getPercent() {
        return percent;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    // Setter 方法
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    // toString 方法，仅用于打印和调试
    @Override
    public String toString() {
        return "QuestionnaireDTO{" +
                "questionId=" + questionId +
                ", stem='" + stem + '\'' +
                ", option='" + option + '\'' +
                ", percent='" + percent + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
