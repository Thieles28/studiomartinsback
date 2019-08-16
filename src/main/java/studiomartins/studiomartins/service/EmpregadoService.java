package studiomartins.studiomartins.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import studiomartins.studiomartins.exception.ResourceNotFoundException;
import studiomartins.studiomartins.model.Empregado;
import studiomartins.studiomartins.repository.EmpregadoRepository;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

public class EmpregadoService {

    EmpregadoRepository empregadoRepository;

    public Empregado buscarEmpregado(@PathVariable("codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        return empregadoRepository.findById(codigoEmpregado).orElseThrow(() -> new ResourceNotFoundException("Empregado náo encontrado para esse codigo" + codigoEmpregado));
    }

    public Empregado getEmpregado(@PathVariable("codigo") Long codigoEmpregado, @RequestBody @Valid Empregado empregadoDetalhe) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(codigoEmpregado)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado não encontrado para esse codigo " + codigoEmpregado));
        empregado.setPerfil(empregadoDetalhe.getPerfil());
        empregado.setNome(empregadoDetalhe.getNome());
        empregado.setSobrenome(empregadoDetalhe.getSobrenome());
        empregado.setRegistro(empregadoDetalhe.getRegistro());
        empregado.setCpf(empregadoDetalhe.getCpf());
        empregado.setTelefone(empregadoDetalhe.getTelefone());
        empregado.setEmail(empregadoDetalhe.getEmail());
        empregado.setEndereco(empregadoDetalhe.getEndereco());
        empregado.setCidade(empregadoDetalhe.getCidade());
        empregado.setCep(empregadoDetalhe.getCep());
        empregado.setEstado(empregadoDetalhe.getEstado());
        return empregadoRepository.save(empregado);
    }

    public Map<String, Boolean> deletarEmpregado(@PathVariable("codigo") Long codigoEmpregado) throws ResourceNotFoundException {
        Empregado empregado = empregadoRepository.findById(codigoEmpregado)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado não encontrado para esse codigo " + codigoEmpregado));
        empregadoRepository.delete(empregado);
        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("Deletado", Boolean.TRUE);
        return resposta;
    }
}
