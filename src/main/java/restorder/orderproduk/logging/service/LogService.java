package restorder.orderproduk.logging.service;

import restorder.orderproduk.logging.entity.LogEntity;

public interface LogService {
    void saveLogToDatabase(LogEntity logEntity);
}
