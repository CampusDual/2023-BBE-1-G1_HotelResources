package com.campusdual.cd2023bbe1g1.ws.core.rest;

import com.campusdual.cd2023bbe1g1.api.core.service.IShiftService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shifts")
public class ShiftController extends ORestController<IShiftService> {

    @Autowired
    private IShiftService shiftService;

    @Override
    public IShiftService getService() {
        return this.shiftService;
    }
}

