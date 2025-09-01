package com.example.demo.service;

import com.example.demo.domain.DemoSample;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {
    private final DemoRepository repo;

    public DemoService(DemoRepository repo) {
        this.repo = repo;
    }

    @Transactional(readOnly = true)
    public DemoSample findByEno(String eno) {
        return repo.findByEno(eno);
    }

}
