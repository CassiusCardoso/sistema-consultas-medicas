package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusMedico;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.consulta.ConsultaInvalidaException;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.medico.MedicoInvalidoException;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.medico.MedicoStatusIndisponivelException;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Crm;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Email;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.Especialidade;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Medico {
    private final UUID id;
    private final Crm crm;
    private final String nome;
    private final Email email;
    private final Especialidade especialidade;
    private final BigDecimal valorConsulta;
    private StatusMedico status;
    private final LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Medico(UUID id, Crm crm, String nome, Email email, Especialidade especialidade, BigDecimal valorConsulta, StatusMedico status, LocalDateTime criadoEm, LocalDateTime atualizadoEm){
        if(id == null){
            throw new MedicoInvalidoException("ID do paciente não pode ser nulo.");
        }
        if(nome == null || nome.isBlank()){
            throw new MedicoInvalidoException("Nome não poder ser vazio.");
        }
        if(valorConsulta == null || valorConsulta.compareTo(BigDecimal.ZERO) < 0){
            throw new ConsultaInvalidaException("O valor da consulta não pode ser negativo.");
        }

        this.id = id;
        this.crm = crm;
        this.nome = nome;
        this.email = email;
        this.especialidade = especialidade;
        this.valorConsulta = valorConsulta;
        this.status = status;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public UUID getId() {
        return id;
    }

    public Crm getCrm() {
        return crm;
    }

    public String getNome() {
        return nome;
    }

    public Email getEmail() {
        return email;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }

    public StatusMedico getStatus() {
        return status;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void desativar(){
        if(this.status == StatusMedico.INDISPONIVEL){
            throw new MedicoStatusIndisponivelException("Não é possível desativar um médico indisponível.");
        }
        this.status = StatusMedico.INDISPONIVEL;
        this.atualizadoEm = LocalDateTime.now();
    }
}
