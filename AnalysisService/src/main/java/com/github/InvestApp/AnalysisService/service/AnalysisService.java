package com.github.InvestApp.AnalysisService.service;

import com.github.InvestApp.AnalysisService.domain.Stocks;
import com.github.InvestApp.AnalysisService.repository.AnalysisRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnalysisService {

  private final AnalysisRepository repo;

  public AnalysisService(AnalysisRepository repo) {
    this.repo = repo;
  }


  public Flux<Stocks> get(int id) {
    return repo.get(id);
  }
  
}