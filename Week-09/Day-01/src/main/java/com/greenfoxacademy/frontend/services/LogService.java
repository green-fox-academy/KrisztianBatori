package com.greenfoxacademy.frontend.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.greenfoxacademy.frontend.models.Log;
import com.greenfoxacademy.frontend.models.LogEntry;
import com.greenfoxacademy.frontend.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class LogService {
    private LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogRepository getLogRepository() {
        return logRepository;
    }

    public void saveLog(Log log) {
        logRepository.save(log);
    }

    public LogEntry collectLogs() {
        LogEntry logEntry = new LogEntry();

        logRepository.findAllIdAndEndpointAndData().forEach(
                log -> {
                    ObjectNode objectNode = new ObjectMapper().createObjectNode();
                    objectNode.put("id", log[0].toString());
                    objectNode.put("endpoint", log[1].toString());
                    objectNode.put("data", log[2].toString());
                    logEntry.getEntries().add(objectNode);
                }
        );
        logEntry.setEntry_count(logEntry.getEntries().size());
        return logEntry;
    }
}
