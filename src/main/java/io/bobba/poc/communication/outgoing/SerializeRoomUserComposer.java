package io.bobba.poc.communication.outgoing;

import io.bobba.poc.communication.protocol.ServerMessage;
import io.bobba.poc.communication.protocol.ServerOpCodes;
import io.bobba.poc.core.rooms.users.RoomUser;

import java.util.Arrays;
import java.util.List;

public class SerializeRoomUserComposer extends ServerMessage {

    public SerializeRoomUserComposer(List<RoomUser> users) {
        super(ServerOpCodes.PLAYERS_DATA);
        appendInt(users.size());
        for (RoomUser user : users) {
            appendInt(user.getVirtualId());
            appendInt(user.getX());
            appendInt(user.getY());
            appendFloat(user.getZ());
            appendInt(user.getRot());
            appendString(user.getUser().getUsername());
            appendString(user.getUser().getLook());
        }
    }

    public SerializeRoomUserComposer(RoomUser user) {
        this(Arrays.asList(user));
    }
}