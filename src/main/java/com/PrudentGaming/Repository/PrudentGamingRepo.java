package com.PrudentGaming.Repository;

import java.util.List;

import org.hibernate.type.descriptor.java.IntegerJavaType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.PrudentGaming.Model.PrudentGamingModel;

@Repository
public interface PrudentGamingRepo extends CrudRepository<PrudentGamingModel, IntegerJavaType>{
    

    @Query(value = "select * from prudent_gaming where game = ?1", nativeQuery = true)
    public List<PrudentGamingModel> searchingBasisOnGame(String game);

    @Query(value = "select * from prudent_gaming where client_id = ?1", nativeQuery = true)
    public List<PrudentGamingModel> searchingBasisOnClientId(int clientId);
    
}
