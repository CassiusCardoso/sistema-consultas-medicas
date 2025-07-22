package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.Plano;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusPaciente;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.paciente.PacienteInvalidoException;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.exceptions.paciente.PacienteInativoException;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Cpf;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Email;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Endereco;
import java.time.LocalDateTime;
import java.util.UUID;

public class Paciente {
    private final UUID id;
    private final String nome;
    private final Cpf cpf;
    private final Email email;
    private final Plano plano;
    private StatusPaciente status;
    private final Endereco endereco;
    private final LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Paciente(UUID id, String nome, Cpf cpf, Email email, Plano plano, StatusPaciente status, Endereco endereco, LocalDateTime criadoEm, LocalDateTime atualizadoEm){

        if(id == null){
            throw new PacienteInvalidoException("ID do paciente não pode ser nulo.");
        }
        if(nome == null || nome.isBlank()){
            throw new PacienteInvalidoException("Nome não poder ser vazio.");
        }
        if(cpf == null || email == null || endereco == null){
            throw new PacienteInvalidoException("Cpf, email e endereço são obrigatórios.");
        }

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.plano = plano;
        this.status = status;
        this.endereco = endereco;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public Email getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void desativar(){
        if(this.status == StatusPaciente.INATIVO){
            throw new PacienteInativoException("Não é possível desativar um paciente inativo.");
        }
        this.status = StatusPaciente.INATIVO;
        this.atualizadoEm = LocalDateTime.now();
    }
}
