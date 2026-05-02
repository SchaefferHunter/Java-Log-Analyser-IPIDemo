package com.example.loganalyzer;

import java.util.List;

/**
 * Analyzes log lines and counts entries by log level.
 * <p>
 * A log line is considered to belong to a level if it contains the level
 * keyword (INFO, WARN, ERROR) as a whole word, case-insensitive.
 */
public class LogAnalyzer {

    public int countInfo(List<String> lines) {
        return countLevel(lines, "INFO");
    }

    public int countWarn(List<String> lines) {
        return countLevel(lines, "WARN");
    }

    public int countError(List<String> lines) {
        return countLevel(lines, "ERROR");
    }

    private int countLevel(List<String> lines, String level) {
        if (lines == null) {
            return 0;
        }
        String pattern = "\\b" + level + "\\b";
        int count = 0;
        for (String line : lines) {
            if (line != null && line.toUpperCase().matches(".*" + pattern + ".*")) {
                count++;
            }
        }
        return count;
    }
}
