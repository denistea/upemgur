/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.validator;

import fr.upem.entity.User;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Denis
 */
@FacesValidator("oldPasswordValidator")
public class OldPasswordValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
        User user = (User) FacesContext.getCurrentInstance().getExternalContext()
               .getSessionMap().get("userSession");
        
        if(user == null || password.equals(user.getPassword())) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong password", null));
        }
    }
    
}
