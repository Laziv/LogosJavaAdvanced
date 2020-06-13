package com.lgs.laziv.lesson5_log4j;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        LOG.trace("Trace");
        LOG.debug("Debug");
        LOG.info("Info");
        LOG.warn("Warning");
        LOG.error("Error");
        LOG.fatal("Fatal");
    }
}
