/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.client.impl.protocol.codec;

import com.hazelcast.client.impl.protocol.ClientMessage;
import com.hazelcast.client.impl.protocol.Generated;
import com.hazelcast.client.impl.protocol.codec.builtin.*;
import com.hazelcast.client.impl.protocol.codec.custom.*;
import com.hazelcast.logging.Logger;

import javax.annotation.Nullable;

import static com.hazelcast.client.impl.protocol.ClientMessage.*;
import static com.hazelcast.client.impl.protocol.codec.builtin.FixedSizeTypesCodec.*;

/*
 * This file is auto-generated by the Hazelcast Client Protocol Code Generator.
 * To change this file, edit the templates or the protocol
 * definitions on the https://github.com/hazelcast/hazelcast-client-protocol
 * and regenerate it.
 */

/**
 * Adds a Migration listener to the cluster.
 */
@Generated("ff4ef43b470d03a4a49b23c5ce4b2b8e")
public final class ClientAddMigrationListenerCodec {
    //hex: 0x001100
    public static final int REQUEST_MESSAGE_TYPE = 4352;
    //hex: 0x001101
    public static final int RESPONSE_MESSAGE_TYPE = 4353;
    private static final int REQUEST_LOCAL_ONLY_FIELD_OFFSET = PARTITION_ID_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int REQUEST_INITIAL_FRAME_SIZE = REQUEST_LOCAL_ONLY_FIELD_OFFSET + BOOLEAN_SIZE_IN_BYTES;
    private static final int RESPONSE_RESPONSE_FIELD_OFFSET = RESPONSE_BACKUP_ACKS_FIELD_OFFSET + BYTE_SIZE_IN_BYTES;
    private static final int RESPONSE_INITIAL_FRAME_SIZE = RESPONSE_RESPONSE_FIELD_OFFSET + UUID_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_START_TIME_FIELD_OFFSET = PARTITION_ID_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_PLANNED_MIGRATIONS_FIELD_OFFSET = EVENT_MIGRATION_START_TIME_FIELD_OFFSET + LONG_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_COMPLETED_MIGRATIONS_FIELD_OFFSET = EVENT_MIGRATION_PLANNED_MIGRATIONS_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_TOTAL_ELAPSED_TIME_FIELD_OFFSET = EVENT_MIGRATION_COMPLETED_MIGRATIONS_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_PARTITION_ID_FIELD_OFFSET = EVENT_MIGRATION_TOTAL_ELAPSED_TIME_FIELD_OFFSET + LONG_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_REPLICA_INDEX_FIELD_OFFSET = EVENT_MIGRATION_PARTITION_ID_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_SOURCE_UUID_FIELD_OFFSET = EVENT_MIGRATION_REPLICA_INDEX_FIELD_OFFSET + INT_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_DEST_UUID_FIELD_OFFSET = EVENT_MIGRATION_SOURCE_UUID_FIELD_OFFSET + UUID_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_SUCCESS_FIELD_OFFSET = EVENT_MIGRATION_DEST_UUID_FIELD_OFFSET + UUID_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_ELAPSED_TIME_FIELD_OFFSET = EVENT_MIGRATION_SUCCESS_FIELD_OFFSET + BOOLEAN_SIZE_IN_BYTES;
    private static final int EVENT_MIGRATION_INITIAL_FRAME_SIZE = EVENT_MIGRATION_ELAPSED_TIME_FIELD_OFFSET + LONG_SIZE_IN_BYTES;
    //hex: 0x001102
    private static final int EVENT_MIGRATION_MESSAGE_TYPE = 4354;

    private ClientAddMigrationListenerCodec() {
    }

    /**
     * if true only node that has the migration sends the request, if false
     * sends all partition lost events.
     */
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings({"UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"})
    public boolean localOnly;

    public static ClientMessage encodeRequest(boolean localOnly) {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        clientMessage.setRetryable(false);
        clientMessage.setOperationName("Client.AddMigrationListener");
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[REQUEST_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, REQUEST_MESSAGE_TYPE);
        encodeInt(initialFrame.content, PARTITION_ID_FIELD_OFFSET, -1);
        encodeBoolean(initialFrame.content, REQUEST_LOCAL_ONLY_FIELD_OFFSET, localOnly);
        clientMessage.add(initialFrame);
        return clientMessage;
    }

    public static boolean decodeRequest(ClientMessage clientMessage) {
        ClientMessage.ForwardFrameIterator iterator = clientMessage.frameIterator();
        ClientMessage.Frame initialFrame = iterator.next();
        return decodeBoolean(initialFrame.content, REQUEST_LOCAL_ONLY_FIELD_OFFSET);
    }

    public static ClientMessage encodeResponse(java.util.UUID response) {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[RESPONSE_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, RESPONSE_MESSAGE_TYPE);
        encodeUUID(initialFrame.content, RESPONSE_RESPONSE_FIELD_OFFSET, response);
        clientMessage.add(initialFrame);

        return clientMessage;
    }

    /**
    * The listener registration id.
    */
    public static java.util.UUID decodeResponse(ClientMessage clientMessage) {
        ClientMessage.ForwardFrameIterator iterator = clientMessage.frameIterator();
        ClientMessage.Frame initialFrame = iterator.next();
        return decodeUUID(initialFrame.content, RESPONSE_RESPONSE_FIELD_OFFSET);
    }

    public static ClientMessage encodeMigrationEvent(long startTime, int plannedMigrations, int completedMigrations, long totalElapsedTime, int partitionId, int replicaIndex, java.util.UUID sourceUuid, java.util.UUID destUuid, boolean success, long elapsedTime) {
        ClientMessage clientMessage = ClientMessage.createForEncode();
        ClientMessage.Frame initialFrame = new ClientMessage.Frame(new byte[EVENT_MIGRATION_INITIAL_FRAME_SIZE], UNFRAGMENTED_MESSAGE);
        initialFrame.flags |= ClientMessage.IS_EVENT_FLAG;
        encodeInt(initialFrame.content, TYPE_FIELD_OFFSET, EVENT_MIGRATION_MESSAGE_TYPE);
        encodeInt(initialFrame.content, PARTITION_ID_FIELD_OFFSET, -1);
        encodeLong(initialFrame.content, EVENT_MIGRATION_START_TIME_FIELD_OFFSET, startTime);
        encodeInt(initialFrame.content, EVENT_MIGRATION_PLANNED_MIGRATIONS_FIELD_OFFSET, plannedMigrations);
        encodeInt(initialFrame.content, EVENT_MIGRATION_COMPLETED_MIGRATIONS_FIELD_OFFSET, completedMigrations);
        encodeLong(initialFrame.content, EVENT_MIGRATION_TOTAL_ELAPSED_TIME_FIELD_OFFSET, totalElapsedTime);
        encodeInt(initialFrame.content, EVENT_MIGRATION_PARTITION_ID_FIELD_OFFSET, partitionId);
        encodeInt(initialFrame.content, EVENT_MIGRATION_REPLICA_INDEX_FIELD_OFFSET, replicaIndex);
        encodeUUID(initialFrame.content, EVENT_MIGRATION_SOURCE_UUID_FIELD_OFFSET, sourceUuid);
        encodeUUID(initialFrame.content, EVENT_MIGRATION_DEST_UUID_FIELD_OFFSET, destUuid);
        encodeBoolean(initialFrame.content, EVENT_MIGRATION_SUCCESS_FIELD_OFFSET, success);
        encodeLong(initialFrame.content, EVENT_MIGRATION_ELAPSED_TIME_FIELD_OFFSET, elapsedTime);
        clientMessage.add(initialFrame);

        return clientMessage;
    }

    public abstract static class AbstractEventHandler {

        public void handle(ClientMessage clientMessage) {
            int messageType = clientMessage.getMessageType();
            ClientMessage.ForwardFrameIterator iterator = clientMessage.frameIterator();
            if (messageType == EVENT_MIGRATION_MESSAGE_TYPE) {
                ClientMessage.Frame initialFrame = iterator.next();
                long startTime = decodeLong(initialFrame.content, EVENT_MIGRATION_START_TIME_FIELD_OFFSET);
                int plannedMigrations = decodeInt(initialFrame.content, EVENT_MIGRATION_PLANNED_MIGRATIONS_FIELD_OFFSET);
                int completedMigrations = decodeInt(initialFrame.content, EVENT_MIGRATION_COMPLETED_MIGRATIONS_FIELD_OFFSET);
                long totalElapsedTime = decodeLong(initialFrame.content, EVENT_MIGRATION_TOTAL_ELAPSED_TIME_FIELD_OFFSET);
                int partitionId = decodeInt(initialFrame.content, EVENT_MIGRATION_PARTITION_ID_FIELD_OFFSET);
                int replicaIndex = decodeInt(initialFrame.content, EVENT_MIGRATION_REPLICA_INDEX_FIELD_OFFSET);
                java.util.UUID sourceUuid = decodeUUID(initialFrame.content, EVENT_MIGRATION_SOURCE_UUID_FIELD_OFFSET);
                java.util.UUID destUuid = decodeUUID(initialFrame.content, EVENT_MIGRATION_DEST_UUID_FIELD_OFFSET);
                boolean success = decodeBoolean(initialFrame.content, EVENT_MIGRATION_SUCCESS_FIELD_OFFSET);
                long elapsedTime = decodeLong(initialFrame.content, EVENT_MIGRATION_ELAPSED_TIME_FIELD_OFFSET);
                handleMigrationEvent(startTime, plannedMigrations, completedMigrations, totalElapsedTime, partitionId, replicaIndex, sourceUuid, destUuid, success, elapsedTime);
                return;
            }
            Logger.getLogger(super.getClass()).finest("Unknown message type received on event handler :" + messageType);
        }

        /**
         * @param startTime The id assigned during the listener registration.
         * @param plannedMigrations The id assigned during the listener registration.
         * @param completedMigrations The id assigned during the listener registration.
         * @param totalElapsedTime The id assigned during the listener registration.
         * @param partitionId The id assigned during the listener registration.
         * @param replicaIndex The id assigned during the listener registration.
         * @param sourceUuid The id assigned during the listener registration.
         * @param destUuid The id assigned during the listener registration.
         * @param success The id assigned during the listener registration.
         * @param elapsedTime The id assigned during the listener registration.
        */
        public abstract void handleMigrationEvent(long startTime, int plannedMigrations, int completedMigrations, long totalElapsedTime, int partitionId, int replicaIndex, java.util.UUID sourceUuid, java.util.UUID destUuid, boolean success, long elapsedTime);
    }
}
