package com.gdsc.game;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterDAO characterDAO;

    public CharacterService(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public int getHpByJob(Job job) {
        return job.getHp();
    }

    public int getMpByJob(Job job) {
        return job.getMp();
    }

    public Character registerCharacter(String name, String job, int level) {
        Character character = new Character();
        character.setName(name);
        character.setJob(job);
        character.setLevel(level);

        Job jobEnum = Job.valueOf(job.toUpperCase());
        character.setJob(jobEnum.toString());

        //기본 hp와 mp
        character.setHp(getHpByJob(jobEnum)+level*10);
        character.setMp(getMpByJob(jobEnum)+level*5);
        
        //dao가 저장하게끔 함
        characterDAO.save(character);

        return character;
    }
}
