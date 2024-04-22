package com.hunsun.fund.questionnaire;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.questionnaire.QuestionnaireService;
import com.hundsun.fund.questionnaire.dto.QuestionnaireDTO;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@RestController
@RequestMapping("/questionnaires") // URL前缀，所有请求都是 /questionnaires 开头
public class QuestionnaireController {
    private static final Logger log = LoggerFactory.getLogger(QuestionnaireController.class);

    @CloudReference
    private QuestionnaireService questionnaireService;

    @PostMapping // 对应HTTP POST，用于创建新的问卷信息
    public Result createQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) {
        log.info("创建新的问卷信息");
        Boolean res = questionnaireService.createQuestionnaire(questionnaireDTO);
        if (res) {
            return Result.success("创建成功");
        } else {
            return Result.error("创建失败");
        }
    }

    @DeleteMapping("/{questionnaireId}") // 对应HTTP DELETE，用于删除指定问卷信息
    public Result deleteQuestionnaire(@PathVariable Long questionnaireId) {
        log.info("删除指定问卷");
        Boolean res = questionnaireService.deleteQuestionnaire(questionnaireId);
        if (res) {
            return Result.success("删除成功");
        } else {
            return Result.error("删除失败");
        }
    }

    @PutMapping("/{questionnaireId}") // 对应HTTP PUT，用于更新指定问卷信息
    public Result updateQuestionnaire(@PathVariable Long questionnaireId, @RequestBody QuestionnaireDTO updatedQuestionnaire) {
        log.info("更新指定问卷信息");
        Boolean res = questionnaireService.updateQuestionnaire(questionnaireId, updatedQuestionnaire);
        if (res) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }
    }

    @GetMapping("/top") // 对应HTTP GET，用于获取前10个问卷的信息
    public Result getTopQuestionnaires() {
        log.info("获取前10个问卷的信息");

        return Result.success(questionnaireService.getTopQuestionnaires());
    }

    @GetMapping("/next")// 对应HTTP GET，用于获取接下来10个问卷的信息
    public Result getNextTenQuestionnaires(@PathVariable Long questionnaireId){

        log.info("获取前10个问卷的信息");

        return Result.success(questionnaireService.getNextQuestionnaires(questionnaireId));
    }
}
