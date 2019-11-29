package ru.job4j.principle003;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExJob {
    private final static Logger LOG = LogManager.getLogger(ExJob.class);

    public static void main(String[] args) {
        int version = 1;
        LOG.trace("trace message {}", version);
        LOG.debug("debug message {}", version);
        LOG.info("info message {}", version);
        LOG.warn("warn message {}", version);
        LOG.error("error message {}", version);
    }
}
