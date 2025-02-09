package com.lubna.job_portal.Controllers;


import com.lubna.job_portal.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;
}
