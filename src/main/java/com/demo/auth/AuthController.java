package com.demo.auth;

import com.demo.entity.User;
import com.demo.secruity.JwtAuthenticationRequest;
import com.demo.secruity.JwtAuthenticationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value="权限申请与认证",tags={"权限申请与认证"})
public class AuthController {
    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;


    @ApiOperation(value="获得用户Token", notes="获得用户Token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authenticationRequest", value = "用户名与密码", required = true, dataType = "JwtAuthenticationRequest")
    })
    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Return the token
        System.out.println(token);
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


    @ApiOperation(value="刷新Token", notes="刷新Token")
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(
            HttpServletRequest request) throws AuthenticationException {
        System.out.println(11);
        String token = request.getHeader(tokenHeader);
        System.out.println(token);
        String refreshedToken = authService.refresh(token);
        System.out.println(refreshedToken);
        if(refreshedToken == null) {
            System.out.println("token 为空！---" + ResponseEntity.badRequest().body(null));
            return ResponseEntity.badRequest().body(null);
        } else {
            System.out.println("新token！---" + ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken)));
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        }
    }


    @ApiOperation(value="用户申请", notes="用户申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addedUser", value = "用户实体user，除去id", required = true, dataType = "User")
    })
    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) throws AuthenticationException{
        return authService.register(addedUser);
    }
}
