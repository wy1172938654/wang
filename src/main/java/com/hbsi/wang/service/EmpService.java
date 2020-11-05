package com.hbsi.wang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hbsi.wang.bean.Emp;
import org.springframework.ui.Model;

public interface EmpService {
//    查询所有员工
   IPage<Emp> selectList(Integer pageNum,Integer pageSize);
//   添加员工
   String insertEmp(Emp emp);
   /**
    * 删除
    * */
   String deleteId(Emp emp);
   /**
    * 修改
    * */
   String updateEmp(Emp emp);

   /**
    * 根据id查询
    *
    * @return*/
  String selectById(String id, Model model);
}
