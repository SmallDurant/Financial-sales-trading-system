package com.hunsun.fund.fund;

import com.hundsun.fund.api.Result;
import com.hundsun.fund.fund.ManagerService;
import com.hundsun.fund.fund.dto.ManagerDTO;
import com.hundsun.fund.log.LogService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @CloudReference
    private ManagerService managerService;
    @CloudReference
    private LogService logService;
    private static final Logger log = LoggerFactory.getLogger(ManagerController.class);
    

    @GetMapping("/get/{managerId}") // 获取指定基金经理的信息
    public Result getManagerById(@PathVariable Long managerId) {
        
        log.info("获取managerId={}的基金经理信息", managerId);
        
        ManagerDTO manager = managerService.findManagerById(managerId);
        
        if (manager != null) {
            return Result.success(manager);
        } else {
            return Result.error("Manager not found");
        }
    }

    @PostMapping("/create") // 创建基金经理
    public Result createManager(@RequestBody ManagerDTO managerDTO) {
        
        log.info("创建新的基金经理");
        
        Boolean success = managerService.createManager(managerDTO);
        
        if (success) {
            Boolean r = logService.AddLogRecord(1L,5,"新增了基金经理的信息", LocalDateTime.now());
            return Result.success("基金经理创建成功");
        } else {
            return Result.error("基金经理创建失败");
        }
    }

    @PutMapping("/update/{managerId}") // 更新基金经理
    public Result updateManager(@PathVariable Long managerId, @RequestBody ManagerDTO managerDTO) {
        
        log.info("更新managerId={}的基金经理信息", managerId);
        
        Boolean success = managerService.updateManager(managerId, managerDTO);
        
        if (success) {
            Boolean r = logService.AddLogRecord(1L,4,"更新了基金经理的信息", LocalDateTime.now());
            return Result.success("基金经理更新成功");
        } else {
            return Result.error("基金经理更新失败");
        }
    }

    @DeleteMapping("/delete/{managerId}") // 删除基金经理
    public Result deleteManager(@PathVariable Long managerId) {
        
        log.info("删除managerId={}的基金经理", managerId);
        
        Boolean success = managerService.deleteManager(managerId);
        
        if (success) {
            Boolean r = logService.AddLogRecord(1L,6,"删除了基金经理的信息", LocalDateTime.now());
            return Result.success( "基金经理删除成功");
        } else {
            return Result.error("基金经理删除失败");
        }
    }
}
