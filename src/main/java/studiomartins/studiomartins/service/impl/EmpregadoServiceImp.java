package studiomartins.studiomartins.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import studiomartins.studiomartins.exception.ResourceNotFoundException;
import studiomartins.studiomartins.model.Empregado;
import studiomartins.studiomartins.repository.EmpregadoRepository;
import studiomartins.studiomartins.service.EmpregadoService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Service
public class EmpregadoServiceImp implements EmpregadoService {

    @Autowired
    EmpregadoRepository empregadoRepository;

    @Override
    public List<Empregado> listarTodosFuncionarios() {
        return this.empregadoRepository.findAll();
    }

    @Override
    public Empregado buscarEmpregado(@PathVariable("codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(codigoEmpregado).orElseThrow(() -> new ResourceNotFoundException("Empregado náo encontrado para esse codigo" + codigoEmpregado));
            if(isNull(empregado)) {
                throw new EmptyResultDataAccessException(1);
            }
        return empregado;
    }

    @Override
    public ResponseEntity<Empregado> cadastrarCampeonato(Empregado empregado) {
        Empregado empregadoSalvo = empregadoRepository.save(empregado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empregadoSalvo);
    }

    @Override
    public ResponseEntity<Empregado> getEmpregado(@PathVariable("codigo") Long codigoEmpregado, @RequestBody @Valid Empregado empregadoDetalhe) throws ResourceNotFoundException {
        Empregado empregado = buscarEmpregado(codigoEmpregado);
        BeanUtils.copyProperties(empregadoDetalhe, empregado, "codigo");
        Empregado salvarEmpregado = empregadoRepository.save(empregado);
        return ResponseEntity.status(HttpStatus.OK).body(salvarEmpregado);
    }

    @Override
    public Map<String, Boolean> deletarEmpregado(@PathVariable("codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(codigoEmpregado)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado não encontrado para esse codigo " + codigoEmpregado));
        empregadoRepository.delete(empregado);
        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Empregado deletado com sucesso!", Boolean.TRUE);
        return resposta;
    }
}
