package com.cyder.atsushi.youtubesync.server;

import com.cyder.atsushi.youtubesync.json_data.BaseResponse;

import java.util.HashMap;

/**
 * Created by atsushi on 2017/11/07.
 */

public class Room extends HttpRequestsHelper {
    private RoomInterface listener = null;

    public Room() {
        super(BaseResponse.class);
    }

    public void setListener(RoomInterface listener) {
        this.listener = listener;
    }

    public void get(final String roomKey) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("room_key", roomKey);
        super.get(params, "rooms", new HttpRequestCallback() {
            @Override
            public void success(Object response) {
                BaseResponse r = (BaseResponse)response;
                listener.onReceived(r.room);
            }
            @Override
            public void failure(){
                //TODO implement
            }
        });
    }
}