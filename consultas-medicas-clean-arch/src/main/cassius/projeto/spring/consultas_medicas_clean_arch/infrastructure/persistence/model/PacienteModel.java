package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.model;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.Plano;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusPaciente;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pacientes")
public class PacienteModel {
    @Id
    private UUID id;
    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)

    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Plano plano;

    @Enumerated(EnumType.STRING)
    private StatusPaciente status;

    @Embedded // <-- Diz ao JPA para embutir os campos da classe EnderecoEmbeddable aqui
    private EnderecoEmbeddable endereco;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime criadoEm;

    @UpdateTimestamp // <-- JPA agora gerencia este campo automaticamente
    private LocalDateTime atualizadoEm;

    public PacienteModel(){}

    public PacienteModel(UUID id, String nome, String cpf, String email, String senha, Plano plano, StatusPaciente status, EnderecoEmbeddable endereco, LocalDateTime criadoEm, LocalDateTime atualizadoEm ){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.plano = plano;
        this.status = status;
        this.endereco = endereco;
        this.criadoEm = criadoEm;
        this.atualizadoEm = atualizadoEm;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public StatusPaciente getStatus() {
        return status;
    }

    public void setStatus(StatusPaciente status) {
        this.status = status;
    }

    public EnderecoEmbeddable getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEmbeddable endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
