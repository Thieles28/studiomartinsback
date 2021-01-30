package studiomartins.studiomartins.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import studiomartins.studiomartins.exception.ResourceNotFoundException;
import studiomartins.studiomartins.model.Empregado;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Service
public interface EmpregadoService {
    List<Empregado> listarTodosFuncionarios();
    ResponseEntity<Empregado> cadastrarCampeonato(Empregado empregado);
    Empregado buscarEmpregado(@PathVariable("codigo") Long codigoEmpregado) throws ResourceNotFoundException;
    ResponseEntity<Empregado> getEmpregado(@PathVariable("codigo") Long codigoEmpregado, @RequestBody @Valid Empregado empregadoDetalhe) throws ResourceNotFoundException;
    Map<String, Boolean> deletarEmpregado(@PathVariable("codigo") Long codigoEmpregado) throws ResourceNotFoundException;
}
