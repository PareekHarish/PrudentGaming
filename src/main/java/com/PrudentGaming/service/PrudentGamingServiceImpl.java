package com.PrudentGaming.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrudentGaming.KafkaIntegration.KafkaTopic;
import com.PrudentGaming.Model.PrudentGamingModel;
import com.PrudentGaming.Repository.PrudentGamingRepo;

@Service
public class PrudentGamingServiceImpl implements PrudentGamingService {

    @Autowired
    private PrudentGamingRepo prudentGamingRepo;

    @Autowired
    private KafkaTopic kafkaTopic;

    @Override
    public List<PrudentGamingModel> addObjectToDB(List<PrudentGamingModel> prudentGaminglist) {
        try{
            Iterable<PrudentGamingModel> iterator = 
            prudentGamingRepo.saveAll(prudentGaminglist);
            Iterator<PrudentGamingModel> itr = iterator.iterator();
            while(itr.hasNext()) {
                if(itr.next().getReturns() > 1500) {
                    kafkaTopic.sendMessage("Test Message");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } 
        
        return null;
    }

    @Override
    public List<PrudentGamingModel> searchingBasisOnGame(String game) {
        return prudentGamingRepo.searchingBasisOnGame(game);
    }

    @Override
    public List<PrudentGamingModel> searchingBasisOnClientId(int clientId) {
        return prudentGamingRepo.searchingBasisOnClientId(clientId);
    }

    @Override
    public List<PrudentGamingModel> searchingBasisOndate(String date) {
        return prudentGamingRepo.searchingBasisOnDate(date);
    }
    
}
