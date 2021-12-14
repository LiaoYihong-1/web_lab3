package Data;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.FacesValidator;
@FacesValidator("validatorInputX")
public class ValidatorInputX implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (value == null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"x validation failed","field must not be null");
            throw new ValidatorException(msg);
        }
        try{
            Double x = Double.parseDouble(value.toString());
            if (x > 5.0 || x < -5.0){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"x validation failed","x must be in range (-5;5)");
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"x validation failed","x must be a number");
            throw new ValidatorException(msg);
        }
    }
}
