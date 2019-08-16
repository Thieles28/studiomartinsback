package studiomartins.studiomartins.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studiomartins.studiomartins.exception.ResourceNotFoundException;
import studiomartins.studiomartins.model.Empregado;
import studiomartins.studiomartins.repository.EmpregadoRepository;
import studiomartins.studiomartins.service.EmpregadoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("empregado")
public class EmpregadoController {
    @Autowired
    EmpregadoRepository empregadoRepository;

    EmpregadoService empregadoService;

    @GetMapping
    public List<Empregado> listarFuncionario() {
        return this.empregadoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Empregado> obterEmpregado(@PathVariable( value = "codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        Empregado empregado = empregadoService.buscarEmpregado(codigoEmpregado);
        return ResponseEntity.ok().body(empregado);
    }

    @PostMapping("/cadastrar")
    public Empregado cadastrarFuncionario(@Valid @RequestBody Empregado empregado) {
        return empregadoRepository.save(empregado);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Empregado> atualizarEmpregado(@PathVariable( value = "codigo") Long codigoEmpregado, @Valid @RequestBody Empregado empregado)
    throws ResourceNotFoundException {
        final Empregado atualizarEmpregado = empregadoService.getEmpregado(codigoEmpregado, empregado);
        return ResponseEntity.ok(atualizarEmpregado);
    }

    @DeleteMapping("/{codigo}")
    public Map<String, Boolean> removerEmpregado(@PathVariable( value = "codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        Map<String, Boolean> resposta = empregadoService.deletarEmpregado(codigoEmpregado);
        return resposta;
    }
}
