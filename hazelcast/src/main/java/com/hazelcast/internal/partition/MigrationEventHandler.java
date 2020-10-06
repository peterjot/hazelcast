package com.hazelcast.internal.partition;

import com.hazelcast.partition.MigrationListener;
import com.hazelcast.partition.ReplicaMigrationEvent;

public class MigrationEventHandler {

    static final int MIGRATION_STARTED = -1;
    static final int MIGRATION_FINISHED = -2;

    private final MigrationListener migrationListener;

    public MigrationEventHandler(MigrationListener migrationListener) {
        this.migrationListener = migrationListener;
    }

    public void handle(ReplicaMigrationEvent event) {
        switch (event.getPartitionId()) {
            case MIGRATION_STARTED:
                migrationListener.migrationStarted(event.getMigrationState());
                break;
            case MIGRATION_FINISHED:
                migrationListener.migrationFinished(event.getMigrationState());
                break;
            default:
                if (event.isSuccess()) {
                    migrationListener.replicaMigrationCompleted(event);
                } else {
                    migrationListener.replicaMigrationFailed(event);
                }
        }
    }
}
