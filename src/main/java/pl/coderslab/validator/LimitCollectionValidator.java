package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class LimitCollectionValidator implements ConstraintValidator<LimitCollection, Collection> {

    private int limit;

    @Override
    public void initialize(LimitCollection limitCollection) {
        this.limit = limitCollection.limit();
    }

    @Override
    public boolean isValid(Collection collection, ConstraintValidatorContext constraintValidatorContext) {
        return collection.size()<=limit;
    }
}
