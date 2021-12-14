package Data;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.FacesValidator;
@FacesValidator("validatorInputR")
public class ValidatorInputR implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (value == null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"R validation failed","field must not be null");
            throw new ValidatorException(msg);
        }
        try{
            Double r = Double.parseDouble(value.toString());
            if (r > 0.1 || r < 3.0){
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"R validation failed","R must be in range (0.1;3)");
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"R validation failed","R must be a number");
            throw new ValidatorException(msg);
        }
    }
}
