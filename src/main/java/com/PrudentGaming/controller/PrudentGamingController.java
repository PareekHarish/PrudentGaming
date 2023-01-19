package com.PrudentGaming.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PrudentGaming.Model.PrudentGamingModel;
import com.PrudentGaming.service.PrudentGamingService;

@RestController
@RequestMapping("/PrudentGaming")
public class PrudentGamingController {
    @Autowired
    private PrudentGamingService prudentGamingService;

    @PostMapping("/addGames")
    public ResponseEntity<HttpStatus> addGameObjectsToDB(@RequestBody List<PrudentGamingModel> list) {
        try {
            prudentGamingService.addObjectToDB(list);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/searchingOnGame")
    public ResponseEntity<List<PrudentGamingModel>> searchingBasisOnGame(@RequestParam(name = "game") String game) {
        return new ResponseEntity<>(prudentGamingService.searchingBasisOnGame(game), HttpStatus.OK);
    }


    @GetMapping("/searchingOnClientId")
    public ResponseEntity<List<PrudentGamingModel>> searchingBasisOnClientId(@RequestParam(name = "clientId") int clientId) {
        return new ResponseEntity<>(prudentGamingService.searchingBasisOnClientId(clientId), HttpStatus.OK);
    }

    @GetMapping("/searchingOnDate")
    public ResponseEntity<List<PrudentGamingModel>> searchingBasisOnDate(@RequestParam(name = "date") String date) {
        return new ResponseEntity<>(prudentGamingService.searchingBasisOndate(date), HttpStatus.OK);
    }

}
