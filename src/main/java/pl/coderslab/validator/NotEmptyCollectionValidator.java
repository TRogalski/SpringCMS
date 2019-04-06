package pl.coderslab.validator;

import pl.coderslab.entity.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;
import java.util.List;

public class NotEmptyCollectionValidator implements ConstraintValidator<NotEmptyCollection, Collection> {
    @Override
    public void initialize(NotEmptyCollection constraintAnnotation) {

    }

    @Override
    public boolean isValid(Collection collection, ConstraintValidatorContext constraintValidatorContext) {
        return collection.size()>0;
    }


}
