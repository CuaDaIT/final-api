package com.aht.angularApi.service;

import com.aht.angularApi.model.Training;
import com.aht.angularApi.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    @Autowired
    TrainingRepository trainingRepository;

    public Training getById(int id){
        return trainingRepository.findById(id);
    }

    public Training getByName(String name){
        return trainingRepository.findByName(name);
    }

    public Training getByCode(int code){
        return trainingRepository.findByCode(code);
    }

    public List<Training> getAll(){
        return trainingRepository.findAll();
    }

    public List<Training> getAllByStatus(int status){
        return trainingRepository.findByStatus(status);
    }

    public void add(Training training){
        trainingRepository.save(training);
    }

    public void addMulti(List<Training> trainings){
        trainingRepository.saveAll(trainings);
    }

    public void removeTraining(int id){
        trainingRepository.deleteById(id);
    }

    public void clear(){
        trainingRepository.deleteAll();
    }

    public void update(int id,Training training){
        training.setId(id);
        trainingRepository.save(training);
    }
}
