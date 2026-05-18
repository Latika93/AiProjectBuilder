package com.aiProjectBuilder.aiProjectBuilder.mapper;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.SignupRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.UserProfileResponse;
import com.aiProjectBuilder.aiProjectBuilder.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);

    UserProfileResponse toUserProfileResponse(User user);

}
