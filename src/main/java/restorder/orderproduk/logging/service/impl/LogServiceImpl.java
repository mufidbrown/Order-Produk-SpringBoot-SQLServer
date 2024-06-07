package restorder.orderproduk.logging.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restorder.orderproduk.logging.entity.LogEntity;
import restorder.orderproduk.logging.repository.LogRepository;
import restorder.orderproduk.logging.service.LogService;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;

    /**
     * Save  {@link LogEntity} entry ke database.
     *
     * @param logEntity  {@link LogEntity} entity yang akan disimpan.
     */
    @Override
    public void saveLogToDatabase(LogEntity logEntity) {
        logEntity.setTime(LocalDateTime.now());
        logRepository.save(logEntity);
    }
}

