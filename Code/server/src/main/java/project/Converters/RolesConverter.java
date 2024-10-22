package project.Converters;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import project.Enums.Roles;

@Converter
public class RolesConverter implements AttributeConverter<Roles, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Roles role) {
        if (role == null) return null;
        return switch (role) {
            case USER -> 1;
            case ADMIN -> 2;
            case SUPER_ADMIN -> 3;
        };
    }

    @Override
    public Roles convertToEntityAttribute(Integer integer) {
        if (integer == null) return null;
        return switch (integer) {
            case 1 -> Roles.USER;
            case 2 -> Roles.ADMIN;
            case 3 -> Roles.SUPER_ADMIN;
            default -> throw new IllegalArgumentException(integer + " not supported.");
        };
    }
}
