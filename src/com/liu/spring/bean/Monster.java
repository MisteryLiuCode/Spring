package com.liu.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Monster {
    private Integer monsterId;
    private String name;
    private String skill;

    public Monster(Integer monsterId, String name, String skill) {
        System.out.println("构造器被调用了");
        this.monsterId = monsterId;
        this.name = name;
        this.skill = skill;
    }

}
