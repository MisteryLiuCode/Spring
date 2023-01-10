package com.liu.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monster {
    private Integer monsterId;
    private String name;
    private String skill;
}
