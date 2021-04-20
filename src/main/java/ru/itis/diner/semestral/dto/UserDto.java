package ru.itis.diner.semestral.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.diner.semestral.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String email;

    public static UserDto from(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }

    public static List<UserDto> from(List<User> list) {
        return list.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
