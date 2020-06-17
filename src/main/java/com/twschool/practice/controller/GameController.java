package com.twschool.practice.controller;

import com.twschool.practice.model.UserGameInfo;
import com.twschool.practice.model.UserGameInfoDTO;
import com.twschool.practice.model.UserGameResponse;
import com.twschool.practice.repository.UserGameRepository;
import com.twschool.practice.service.GuessNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @Autowired
    GuessNumberService guessNumberService;

    @Autowired
    UserGameRepository userGameRepository;
    @PostMapping("/check")
    public UserGameResponse check(@RequestBody UserGameInfoDTO userGameInfoDTO){

        UserGameInfo userGameInfo = userGameRepository.getUserGameInfoById(userGameInfoDTO.getUserId());

        if (userGameInfo == null){
            UserGameInfo registerUserGameInfo = new UserGameInfo();
            registerUserGameInfo.setAnswer(null);
            registerUserGameInfo.setCount(0);
            registerUserGameInfo.setIntegral(0);
            registerUserGameInfo.setUserId(userGameInfoDTO.getUserId());
            registerUserGameInfo.setExtraIntegral(0);
            registerUserGameInfo.setContinuousRightCount(0);

            userGameRepository.registerUserGameInfo(registerUserGameInfo);

            userGameInfo = registerUserGameInfo;
        }

        return guessNumberService.playGame(userGameInfoDTO.getGuess(), userGameInfo);

    }

}
