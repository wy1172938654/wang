package com.hbsi.wang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbsi.wang.bean.Emp;
import com.hbsi.wang.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper extends BaseMapper<Emp> {
    IPage<Emp> selectEmpAll(Page page);
//    添加员工
    Integer insertEmp(Emp emp);
//    删除员工
    Integer deleteId(Emp emp);
//  修改员工
    Integer updateEmp(Emp emp);
}
