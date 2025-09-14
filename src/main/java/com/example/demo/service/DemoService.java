package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.repository.DemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = true)
    public List<FactorScore> factorByBrc(String brc) {
        return repo.factorByBrc(brc);
    }

    @Transactional(readOnly = true)
    public List<StockPrice> priceByBrc(String brc) {
        return repo.priceByBrc(brc);
    }

    @Transactional(readOnly = true)
    public List<StockOutlook> outlookByBrc(String brc) {
        return repo.outlookByBrc(brc);
    }

    @Transactional(readOnly = true)
    public List<OfficeFinancials> incomeByBrc(String brc) { return repo.incomeByBrc(brc); }

    @Transactional(readOnly = true)
    public List<OfficeFinancials> profitByBrc(String brc) { return repo.profitByBrc(brc); }

    @Transactional(readOnly = true)
    public List<OfficeFinancials> progrowthByBRC(String brc) { return repo.progrowthByBRC(brc); }

    @Transactional(readOnly = true)
    public List<BrcInfo> descByBRC(String brc) { return repo.descByBRC(brc); }
}
