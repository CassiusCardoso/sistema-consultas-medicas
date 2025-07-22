package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.medicoendereco.CepInvalidoException;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.medicoendereco.MedicoEnderecoInvalidoException;
import java.util.UUID;

public class MedicoEndereco {
    private final UUID id;
    private String logradouro;
    private String numero;
    private final String complemento;
    private final String bairro;
    private final String cidade;
    private final String uf;
    private final String cep;
    private final Medico medico;

    public MedicoEndereco(UUID id, String logradouro, String numero, String complemento, String bairro, String cidade, String uf, String cep, Medico medico) {
        if(id == null){
            throw new MedicoEnderecoInvalidoException("ID do endereço não pode ser nulo.");
        }
        if(cep.isBlank()){
            throw new CepInvalidoException("Cep é obrigatório, não pode ser nulo.");
        }
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.medico = medico;
    }

    public UUID getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public Medico getMedico() {
        return medico;
    }


}
