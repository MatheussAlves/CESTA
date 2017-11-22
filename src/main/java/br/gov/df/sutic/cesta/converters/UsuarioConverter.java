import br.gov.df.sutic.cesta.entities.Usuario;
import br.gov.df.sutic.cesta.persistence.UsuarioFacade;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Conversor de usuários.
 * @author Bruno Santos
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter
{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String 
            string)
    {
        if (string == null || string.length() == 0)
            return null;
        Long id = new Long(string);
        return CDI.current().select(UsuarioFacade.class).get().find(id);
    }
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object 
            object)
    {
        if (object == null)
            return null;
        if (object instanceof Usuario)
        {
            Usuario empresa = (Usuario) object;
            return empresa.getId() == null ? "" : empresa.getId().toString();
        }
        else
            throw new IllegalArgumentException("Objeto " + object + " é do tipo"
                    + " " + object.getClass().getName() + " e não do tipo " +
                    Usuario.class.getName() + ".");
    }
}