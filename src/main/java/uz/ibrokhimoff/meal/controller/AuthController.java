package uz.ibrokhimoff.meal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.ibrokhimoff.meal.dto.auth.AuthUserDto;
import uz.ibrokhimoff.meal.dto.auth.SessionDto;
import uz.ibrokhimoff.meal.dto.response.DataDto;
import uz.ibrokhimoff.meal.service.AuthUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController extends AbstractController<AuthUserService> {

    public AuthController(AuthUserService service) {
        super(service);
    }


    @RequestMapping(value = PATH + "/auth/token", method = RequestMethod.POST)
    public ResponseEntity<DataDto<SessionDto>> getToken(@RequestBody AuthUserDto dto) {
        return service.getToken(dto);
    }

    @RequestMapping(value = PATH + "/auth/refresh-token", method = RequestMethod.GET)
    public ResponseEntity<DataDto<SessionDto>> getToken(HttpServletRequest request, HttpServletResponse response) {
        return service.refreshToken(request, response);
    }

}
