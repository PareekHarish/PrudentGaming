package com.PrudentGaming.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PrudentGaming.Model.PrudentGamingModel;

public interface PrudentGamingService {
    
    public List<PrudentGamingModel> addObjectToDB(List<PrudentGamingModel> prudentGaminglist);

    public List<PrudentGamingModel> searchingBasisOnGame(String game);

    public List<PrudentGamingModel> searchingBasisOnClientId(int clientId);

}
