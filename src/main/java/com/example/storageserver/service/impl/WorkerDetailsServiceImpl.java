package com.example.storageserver.service.impl;

import com.example.storageserver.model.Worker;
import com.example.storageserver.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WorkerDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Worker worker = this.workerRepository.findByEmail(email);
        if (worker == null) {
            throw new UsernameNotFoundException("Worker with this email not found in data base");
        }

        return worker;
    }
}

