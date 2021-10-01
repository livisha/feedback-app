package com.company.aai.feedback.repositories;

import com.company.aai.feedback.models.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface LinkRepository extends JpaRepository<LinkEntity, Integer> {

    @Query(value = "select l from LinkEntity l where l.pnr= :pnr and l.uuid= :uuid")
    Optional<LinkEntity> isFeedbackLink(String pnr,String uuid);

    @Transactional
    @Modifying
    @Query(value = "delete from LinkEntity l where l.pnr= :pnr and l.uuid= :uuid")
    void deleteByPnrAndUuid(String pnr, String uuid);

}