package com.campusdual.cd2023bbe1g1.ws.core.rest;


import com.campusdual.cd2023bbe1g1.api.core.service.IUserService;
import com.campusdual.cd2023bbe1g1.model.core.dao.EmployeesEntryDepartureDAO;
import com.campusdual.cd2023bbe1g1.model.core.dao.UserDAO;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserRestController extends ORestController<IUserService> {

    @Autowired
    private IUserService userSrv;

    @Override
    public IUserService getService() {
        return this.userSrv;
    }

    @PostMapping(
            value = "/login",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityResult> login() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityResult> addUser(@RequestBody Map<? super Object, ? super Object> attrMap) {
        attrMap = (Map<? super Object, ? super Object>) attrMap.get("data");
        attrMap.computeIfAbsent(UserDAO.ROLE_IDS, k -> List.of(IUserService.CLIENT_ROLE_ID));
        return new ResponseEntity<>(userSrv.userInsert(attrMap), HttpStatus.OK);
    }

    @PutMapping("/update")
    public EntityResult userUpdate(@RequestBody Map<? super Object, ? super Object> attrMap, Map<? super Object, ? super Object> keyMap, Authentication authentication) {
        EntityResult result;

        if (!((UserInformation) authentication.getPrincipal()).getUsername().equals(keyMap.get(EmployeesEntryDepartureDAO.LOGIN_NAME))) {
            result = new EntityResultMapImpl();
            result.setCode(EntityResult.OPERATION_WRONG);
            result.setMessage(EmployeesEntryDepartureDAO.E_CANNOT_CLOCK_OUT_OTHERS);
            return result;
        }

        return userSrv.userUpdate(attrMap, keyMap);
    }

}
