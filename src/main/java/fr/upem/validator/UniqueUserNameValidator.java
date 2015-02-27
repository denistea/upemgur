/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.upem.validator;

import fr.upem.dao.UserDAO;
import javax.ejb.EJB;
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
@FacesValidator("uniqueUserNameValidator")
public class UniqueUserNameValidator implements Validator {
    @EJB
    private UserDAO userDAO;
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String userName = (String) value;
        if(userDAO.findByUserName(userName) != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "UserName already used", null));
        }
    }    
}
