package com.example.loganalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LogAnalyzerTest {

    private LogAnalyzer analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new LogAnalyzer();
    }

    @Test
    void countsInfoEntries() {
        List<String> lines = List.of(
            "INFO  Application started",
            "INFO  Loading configuration",
            "INFO  Database connected"
        );
        assertEquals(3, analyzer.countInfo(lines));
    }

    @Test
    void countsWarnEntries() {
        List<String> lines = List.of(
            "WARN  Disk space low",
            "WARN  Retry attempt 1",
            "INFO  Recovered"
        );
        assertEquals(2, analyzer.countWarn(lines));
    }

    @Test
    void countsErrorEntries() {
        List<String> lines = List.of(
            "ERROR Connection refused",
            "ERROR Null pointer in handler",
            "WARN  Falling back"
        );
        assertEquals(2, analyzer.countError(lines));
    }

    @Test
    void handlesMixedLogLines() {
        List<String> lines = List.of(
            "2025-01-12 INFO  start",
            "2025-01-12 WARN  warning one",
            "2025-01-12 ERROR boom",
            "2025-01-12 INFO  ok",
            "2025-01-12 ERROR boom again"
        );
        assertEquals(2, analyzer.countInfo(lines));
        assertEquals(1, analyzer.countWarn(lines));
        assertEquals(2, analyzer.countError(lines));
    }

    @Test
    void handlesEmptyAndNullInput() {
        assertEquals(0, analyzer.countInfo(List.of()));
        assertEquals(0, analyzer.countWarn(null));
        assertEquals(0, analyzer.countError(List.of("just some text without a level")));
    }
}
