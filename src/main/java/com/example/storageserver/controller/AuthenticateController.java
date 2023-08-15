package com.example.storageserver.controller;

import com.example.storageserver.config.JwtUtils;
import com.example.storageserver.model.JwtRequest;
import com.example.storageserver.model.JwtResponse;
import com.example.storageserver.model.Worker;
import com.example.storageserver.service.impl.WorkerDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private WorkerDetailsServiceImpl workerDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Worker not found");
        }

        UserDetails userDetails = this.workerDetailsService.loadUserByUsername(jwtRequest.getEmail());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("Worker disabled " + e.getMessage());
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid credentials " + e.getMessage());
        }
    }

    @GetMapping("/current-worker")
    public Worker getCurrentWorker(Principal principal) {
        return ((Worker) this.workerDetailsService.loadUserByUsername(principal.getName()));
    }
}
