package com.gdsc.game;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Character character) {
        entityManager.persist(character); // 엔티티를 데이터베이스에 저장
    }
}
