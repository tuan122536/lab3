package lab3.anhtuan.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lab3.anhtuan.repository.IUserRepository;
import lab3.anhtuan.validator.annotation.ValidUserName;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUserNameValidator implements ConstraintValidator<ValidUserName, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(username) == null;
    }
}