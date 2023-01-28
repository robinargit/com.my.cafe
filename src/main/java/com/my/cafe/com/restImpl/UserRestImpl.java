package com.my.cafe.com.restImpl;

import com.my.cafe.com.POJO.User;
import com.my.cafe.com.contests.CafeConstant;
import com.my.cafe.com.rest.UserRest;
import com.my.cafe.com.service.UserService;
import com.my.cafe.com.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            return userService.signUp(requestMap);

        }catch (Exception e){
            e.printStackTrace();
        }

        return CafeUtils.getResponseEntity(CafeConstant.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
