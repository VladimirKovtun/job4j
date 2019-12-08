package ru.job4j.principle004;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UsageLog4j2 {
    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class);

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}