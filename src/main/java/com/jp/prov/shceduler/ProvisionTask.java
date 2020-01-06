package com.jp.prov.shceduler;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;

public class ProvisionTask extends BaseTask {
    @Override
    void taskToRun() {
        // programs to be executed
        System.out.println("Provision Execute");
    }

    @Override
    void executeThread(int frequency) {
        final ScheduledFuture<?> configHandle =
                scheduler.scheduleAtFixedRate(this::taskToRun, 0, frequency, SECONDS);
    }
}
