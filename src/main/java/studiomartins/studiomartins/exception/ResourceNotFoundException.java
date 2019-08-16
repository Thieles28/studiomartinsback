package studiomartins.studiomartins.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 8323880807640338035L;

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}
