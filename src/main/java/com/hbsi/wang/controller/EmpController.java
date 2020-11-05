package com.hbsi.wang.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hbsi.wang.bean.Emp;
import com.hbsi.wang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;
    @RequestMapping("/getAll/{pageNum}/{pageSize}")
    public String getAll(Model model,@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        IPage<Emp> emps=empService.selectList(pageNum,pageSize);
        model.addAttribute("emps",emps);
        return "ems/emplist";
    }
    //跳转到添加用户页面
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "ems/addEmp";
    }
    @RequestMapping("/addSave")
    public String addSave(Emp emp){
        return  empService.insertEmp(emp);

    }
    /**
     * 删除
     * */
    @RequestMapping("/del")
    public String del(Emp emp){
        return empService.deleteId(emp);
    }
    /**
     * 回显
     * */
    @RequestMapping("/toUpdate")
    public String toUpdate(String id,Model model){
        return empService.selectById(id,model);
    }
    /**
     * 修改
     * */
    @RequestMapping("/updateSave")
    public String updateSave(Emp emp){
        return empService.updateEmp(emp);
    }
}
