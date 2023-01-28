package com.my.cafe.com.serviceImpl;

import com.my.cafe.com.POJO.User;
import com.my.cafe.com.contests.CafeConstant;
import com.my.cafe.com.dao.UserDao;
import com.my.cafe.com.service.UserService;
import com.my.cafe.com.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        try {

            if (validateSignUpMap(requestMap)) {

                User user = userDao.findByEmaiid(requestMap.get("email"));

                if (Objects.isNull(user)) {

                    userDao.save(getUserFromMap(requestMap));

                } else {

                    return CafeUtils.getResponseEntity(CafeConstant.EMAIL_ALREADY_HERE, HttpStatus.INTERNAL_SERVER_ERROR);
                }


            } else {
                return CafeUtils.getResponseEntity(CafeConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }


        } catch (Exception e) {

            e.printStackTrace();

        }

        return CafeUtils.getResponseEntity(CafeConstant.DATA_INSERTED, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {

        if (
                requestMap.containsKey("name") && requestMap.containsKey("contactNumber") && requestMap.containsKey("email")
                        && requestMap.containsKey("password")) {
            return true;
        }
        return false;

    }


    private User getUserFromMap(Map<String, String> requestMap) {

        User user = new User();

        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setStatus("false");
        user.setRole("user");

        return user;
    }
}
