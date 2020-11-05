package com.hbsi.wang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private String id;
    private String name;
    private int age;
    private Date bir;
    private String state;

}
