package com.aht.angularApi.repository;

import com.aht.angularApi.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    Training findById(int id);
    Training findByCode(int code);
    Training findByName(String name);
    List<Training> findByStatus(int status);
}
