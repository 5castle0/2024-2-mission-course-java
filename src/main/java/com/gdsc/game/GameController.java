package com.gdsc.game;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final Game gameService;
    private final CharacterService characterService;

    public GameController(Game gameService, CharacterService characterService) {
        this.gameService = gameService;
        this.characterService = characterService;
    }

    @GetMapping("/character/{name}/state")
    public Character getCharacterState(@PathVariable String name) {
        return gameService.getCharacterState(name);
    }

    @GetMapping("/character/{name}/skill")
    public String getAvailableSkill(@PathVariable String name){
        return gameService.getAvailableSKill(name);
    }



    @PostMapping("/action")
    public String performAction(@RequestBody ActionRequest request) {
        System.out.println(request.getName());
        System.out.println(request.getNumber());
        return gameService.performAction(request.getName(), request.getNumber());
    }
    public static class ActionRequest {
        private String name;
        private int number;

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCharacter(@RequestBody CharacterDTO characterRequest){

        String name = characterRequest.getName();
        String job = characterRequest.getJob();
        Integer level = characterRequest.getLevel();

        //지정되지 않은 형식
        if (name == null || name.isBlank() || job == null || level==null|| level <= 0) {
            return ResponseEntity.badRequest().build();
        }

        //존재하지 않는 직업
        Job existingJob;
        try {
            existingJob = Job.valueOf(job.toUpperCase());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // 등록
        Character character = characterService.registerCharacter(name, job, level);
        String message = "registered";
        return ResponseEntity.ok(message);

    }

}
