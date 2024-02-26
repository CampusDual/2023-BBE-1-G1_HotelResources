package com.campusdual.cd2023bbe1g1.ws.core.rest;

import com.campusdual.cd2023bbe1g1.api.core.service.IRoomService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController extends ORestController<IRoomService> {

    @Autowired
    private IRoomService roomService;

    @Override
    public IRoomService getService() {
        return this.roomService;
    }

}
