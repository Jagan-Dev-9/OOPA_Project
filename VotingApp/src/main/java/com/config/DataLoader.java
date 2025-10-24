package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;
import com.model.Candidate;
import com.repository.CandidateRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            // ensure an admin user exists for quick testing
            User admin = userRepository.getUserByEmail("admin");
            if (admin == null) {
                User u = new User();
                u.setEmail("admin");
                u.setName("Administrator");
                u.setPassword("admin"); // NoOpPasswordEncoder is used
                u.setPhone(0);
                u.setStatus(null);
                u.setRole("ROLE_ADMIN");
                userRepository.save(u);
            }

            // ensure basic candidate entries exist (candidate1..candidate4)
            String[] candidates = {"candidate1", "candidate2", "candidate3", "candidate4"};
            for (String cName : candidates) {
                Candidate c = candidateRepository.getCandidateByCandidate(cName);
                if (c == null) {
                    Candidate newC = new Candidate();
                    newC.setCandidate(cName);
                    newC.setVotes(0);
                    candidateRepository.save(newC);
                }
            }
        } catch (Exception e) {
            // avoid startup failure if DB not ready; log to console
            System.out.println("DataLoader: could not ensure admin user exists: " + e.getMessage());
        }
    }

}
