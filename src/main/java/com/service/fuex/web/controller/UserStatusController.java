package com.service.fuex.web.controller;

import com.service.fuex.web.dto.UserStatusDTO;
import com.service.fuex.web.model.UserStatus;
import com.service.fuex.web.response.CommonResponse;
import com.service.fuex.web.response.CommonResponseGenerator;
import com.service.fuex.web.service.UserStatusImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/reference/user-status/")
public class UserStatusController {

    @Autowired
    private UserStatusImpl userStatusService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommonResponseGenerator commonResponseGenerator;

    @GetMapping
    public CommonResponse<List<UserStatusDTO>> getAll() {

        Stream<Object> userStatusList = userStatusService.getAll().stream().map(userStatus -> modelMapper.map(userStatus, UserStatusDTO.class));

        return commonResponseGenerator.successResponse(userStatusList);
    }

    @PostMapping
    public CommonResponse<UserStatusDTO> createArticleStatus(@Valid @RequestBody UserStatusDTO userStatusDTORequire) {

        UserStatus userStatusRequire = modelMapper.map(userStatusDTORequire, UserStatus.class);

        UserStatus userStatus = userStatusService.createUserStatus(userStatusRequire);

        UserStatusDTO response = modelMapper.map(userStatus, UserStatusDTO.class);

        return commonResponseGenerator.successResponse(response);
    }
}
