package studiomartins.studiomartins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studiomartins.studiomartins.exception.ResourceNotFoundException;
import studiomartins.studiomartins.model.Empregado;
import studiomartins.studiomartins.service.impl.EmpregadoServiceImp;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("empregado")
public class EmpregadoController {

    @Autowired
    private EmpregadoServiceImp empregadoServiceImp;

    @GetMapping
    public List<Empregado> listarFuncionario() {
        return empregadoServiceImp.listarTodosFuncionarios();
    }

    @GetMapping("{codigo}")
    public Empregado obterEmpregado(@PathVariable(value = "codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        return empregadoServiceImp.buscarEmpregado(codigoEmpregado);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<Empregado> cadastrarFuncionario(@Valid @RequestBody Empregado empregado) {
        return empregadoServiceImp.cadastrarCampeonato(empregado);
    }

    @PutMapping("{codigo}")
    public ResponseEntity<Empregado> atualizarEmpregado(@PathVariable(value = "codigo") Long codigoEmpregado, @Valid @RequestBody Empregado empregado)
    throws ResourceNotFoundException {
        return empregadoServiceImp.getEmpregado(codigoEmpregado, empregado);
    }

    @DeleteMapping("{codigo}")
    public Map<String, Boolean> removerEmpregado(@PathVariable(value = "codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        Map<String, Boolean> resposta = empregadoServiceImp.deletarEmpregado(codigoEmpregado);
        return resposta;
    }
}
