package com.gdsc.game;

import java.util.Arrays;
import java.util.List;

public enum Job {
    //체력,마나,스킬
    KNIGHT("Knight",100,0,Arrays.asList("attack,defense")),
    WIZARD("Wizard",50,50,Arrays.asList("defense,attack2,attack3,attackHard"));

    public String getJob() {
        return job;
    }

    private String job;

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    private int hp;
    private int mp;
    private List<String> skills;

    Job(String job, int hp, int mp, List<String> skills) {
        this.hp = hp;
        this.mp = mp;
        this.skills = skills;
    }



}
