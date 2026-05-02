package com.example.loganalyzer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> sampleLog = List.of(
            "2025-01-12 09:14:02 INFO  Application started",
            "2025-01-12 09:14:05 INFO  Loading configuration",
            "2025-01-12 09:14:07 WARN  Config file missing optional key",
            "2025-01-12 09:14:09 INFO  Connecting to database",
            "2025-01-12 09:14:10 ERROR Database connection failed",
            "2025-01-12 09:14:11 WARN  Retrying connection",
            "2025-01-12 09:14:13 INFO  Database connected",
            "2025-01-12 09:14:20 ERROR Unhandled exception in handler"
        );

        LogAnalyzer analyzer = new LogAnalyzer();
        System.out.println("Log Analyzer Demo");
        System.out.println("-----------------");
        System.out.println("INFO  entries: " + analyzer.countInfo(sampleLog));
        System.out.println("WARN  entries: " + analyzer.countWarn(sampleLog));
        System.out.println("ERROR entries: " + analyzer.countError(sampleLog));
    }
}
