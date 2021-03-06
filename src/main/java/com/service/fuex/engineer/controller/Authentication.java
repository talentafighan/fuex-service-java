package com.service.fuex.engineer.controller;

import com.service.fuex.engineer.service.ValidateImpl;
import com.service.fuex.web.dto.TemporaryOtpDTO;
import com.service.fuex.web.dto.UserDTO;
import com.service.fuex.web.exception.ResourceNotFoundExceotion;
import com.service.fuex.web.model.TemporaryOtp;
import com.service.fuex.web.model.User;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class Authentication {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @Autowired
    private ValidateImpl validateService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResponse<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTORequire) throws ResourceNotFoundExceotion {
        User userDTO = modelMapper.map(userDTORequire, User.class);

        User user = validateService.register(userDTO);

        UserDTO response = modelMapper.map(user, UserDTO.class);

        return commonResponseGenerator.successResponse(response);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResponse<UserDTO> login(HttpServletRequest request, TemporaryOtp createTemporaryOtp) throws ResourceNotFoundExceotion{
//        User userDTO = modelMapper.map(request, User.class);
//
//        User user = (User) userService.login((HttpServletRequest) userDTO);
//
//        UserDTO response = modelMapper.map(user, UserDTO.class);
//
//        return commonResponseGenerator.successResponse(response);
        return commonResponseGenerator.successResponse(validateService.login(request,createTemporaryOtp));
    }

    @RequestMapping(value = "/checking-avalibility-user", method = RequestMethod.GET)
    public CommonResponse<UserDTO> getUserByEmail(HttpServletRequest request) throws ResourceNotFoundExceotion{
//        User userDTO = modelMapper.map(request, User.class);
//
//        User user = (User) userService.getUserByMobilePhoneNumber((HttpServletRequest) userDTO);
//
//        UserDTO response = modelMapper.map(user, UserDTO.class);
//
//        return commonResponseGenerator.successResponse(response);
        return commonResponseGenerator.successResponse(validateService.getUserByEmail(request));
    }

    @RequestMapping(value = "/login/checking-otp", method = RequestMethod.GET)
    public CommonResponse<TemporaryOtpDTO> checkingOtp(@RequestParam(name = "otpNumber") String otpNumber,@RequestParam(name = "email") String email) throws ResourceNotFoundExceotion{
        return commonResponseGenerator.successResponse(validateService.checkingOtp(otpNumber,email));
    }
}
