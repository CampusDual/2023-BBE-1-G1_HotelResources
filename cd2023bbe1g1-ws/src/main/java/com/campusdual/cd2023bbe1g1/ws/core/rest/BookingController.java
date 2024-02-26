package com.campusdual.cd2023bbe1g1.ws.core.rest;

import com.campusdual.cd2023bbe1g1.api.core.service.IBookingService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController extends ORestController<IBookingService> {

    @Autowired
    private IBookingService bookingService;

    @Override
    public IBookingService getService() {
        return this.bookingService;
    }

}
