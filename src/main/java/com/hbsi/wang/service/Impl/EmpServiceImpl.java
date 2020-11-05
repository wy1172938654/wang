package com.hbsi.wang.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbsi.wang.bean.Emp;
import com.hbsi.wang.mapper.EmpMapper;
import com.hbsi.wang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.UUID;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public IPage<Emp> selectList(Integer pageNum, Integer pageSize) {
        Page<Emp> empPage=new Page<>(pageNum,pageSize);
        return empMapper.selectEmpAll(empPage);
    }

    //添加员工
    @Override
    public String insertEmp(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        emp.setState("000");
        Integer integer = empMapper.insertEmp(emp);
        if (integer>0){
            return "redirect:/emp/getAll/1/2";
        }else {
            return "ems/addEmp";
        }
    }

    /**
     * 删除
     * */
    @Override
    public String deleteId(Emp emp) {
        emp.setState("999");
        empMapper.deleteId(emp);
        return "redirect:/emp/getAll/1/2";
    }

    @Override
    public String updateEmp(Emp emp) {
        empMapper.updateEmp(emp);
        return "redirect:/emp/getAll/1/2";
    }

    @Override
    public String selectById(String id, Model model) {
        Emp emp = empMapper.selectById(id);
        model.addAttribute("emp",emp);
        return "ems/updateEmp";
    }

}
