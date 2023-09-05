package com.example.storageserver;

import com.example.storageserver.model.Position;
import com.example.storageserver.model.Worker;
import com.example.storageserver.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class StorageserverApplication implements CommandLineRunner {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(StorageserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("START");

//        Worker worker = new Worker();
//
//        Position position = new Position();
//        position.setId(1);
//        position.setPosition("DIRECTOR");
//
//        worker.setId(1L);
//        worker.setName("Jon");
//        worker.setSurname("Doe");
//        worker.setPatronymic("Doe");
//        worker.setPhone("+380936178150");
//        worker.setEmail("jondoe@gmail.com");
//        worker.setPassword(this.bCryptPasswordEncoder.encode("pass"));
//
//        Set<Position> positions = new HashSet<>();
//        positions.add(position);
//
//        worker.setPositions(positions);
//
//        Worker finalWorker = this.workerService.create(worker);
//        System.out.println(finalWorker.getEmail());
    }
}
