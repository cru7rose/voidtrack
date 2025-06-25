package com.voidtracker.oms.order.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EpodService {
    @Autowired
    private EpodRepository epodRepository;

    public void saveEpod(EpodDto epod) {
        epodRepository.save(epod);
    }

    public List<EpodDto> getAllEpoods() {
        return epodRepository.findAll();
    }
}
