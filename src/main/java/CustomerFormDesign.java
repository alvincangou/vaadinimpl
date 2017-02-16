import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.declarative.Design;

import java.io.Serializable;

/**
 * Created by cangou on 15/02/17.
 */
public class CustomerFormDesign extends FormLayout {

    protected TextField nom;
    protected Button ok;

    public CustomerFormDesign(){
        Design.read(this);
    }
}
