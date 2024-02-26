package com.campusdual.cd2023bbe1g1.ws.core.rest;

import com.campusdual.cd2023bbe1g1.api.core.service.IHotelService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController extends ORestController<IHotelService> {

    @Autowired
    private IHotelService hotelService;

    @Override
    public IHotelService getService() {
        return this.hotelService;
    }

}