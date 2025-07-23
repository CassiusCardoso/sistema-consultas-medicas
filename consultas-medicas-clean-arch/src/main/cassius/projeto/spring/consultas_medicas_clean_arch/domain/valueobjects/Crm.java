package cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects;

import java.util.Set;

public class Crm {
    private final String numero;
    private final String uf;

    private static final Set<String> UF_VALIDAS = Set.of(
            "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT",
            "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS",
            "RO", "RR", "SC", "SP", "SE", "TO"
    );

    public Crm(String numeroComUf) {
        if (numeroComUf == null || numeroComUf.isBlank()) {
            throw new IllegalArgumentException("CRM não pode ser nulo ou vazio.");
        }

        String[] partes = numeroComUf.split("/");
        if (partes.length != 2) {
            throw new IllegalArgumentException("CRM deve estar no formato NÚMERO/UF.");
        }

        String numero = partes[0].trim();
        String uf = partes[1].trim().toUpperCase();

        if (!numero.matches("\\d{4,7}")) {
            throw new IllegalArgumentException("Número do CRM deve conter entre 4 e 7 dígitos.");
        }

        if (!UF_VALIDAS.contains(uf)) {
            throw new IllegalArgumentException("UF do CRM inválida.");
        }

        this.numero = numero;
        this.uf = uf;
    }

    public String getValor() {
        return numero + "/" + uf;
    }
}