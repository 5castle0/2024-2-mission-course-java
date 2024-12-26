package com.gdsc.game;

import org.springframework.stereotype.Service;

@Service
public class CharacterService {
    private final CharacterDAO characterDAO;

    public CharacterService(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    public Character registerCharacter(String name, String job, int level) {
        Character character = new Character();
        character.setName(name);
        character.setJob(job);
        character.setLevel(level);

        //dao가 저장하게끔 함
        characterDAO.save(character);

        return character;
    }
}
