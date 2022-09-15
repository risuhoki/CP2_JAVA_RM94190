package br.com.fiap;

public class Usuario {
    private String titular;
    private Double numero;
    private String tpConta;
    private String ativa;
    private Double limite;
    private Double saldo;


    
   
    @Override
    public String toString() {
        return "Usuario [Titular = " + titular + ", Número = " + numero + ", Tipo de Conta = " + tpConta + ", Ativa = " + ativa
                + ", Limite = " + limite + ", Saldo = " + saldo + "]";
    }

    public Usuario(String titular, Double numero, String tpConta, String ativa, Double limite, Double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.tpConta = tpConta;
        this.ativa = ativa;
        this.limite = limite;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public Double getNumero() {
        return numero;
    }
    public void setNumero(Double numero) {
        this.numero = numero;
    }
    public String getTpConta() {
        return tpConta;
    }
    public void setTpConta(String tpConta) {
        this.tpConta = tpConta;
    }
    public String getAtiva() {
        return ativa;
    }
    public void setAtiva(String ativa) {
        this.ativa = ativa;
    }
    public Double getLimite() {
        return limite;
    }
    public void setLimite(Double limite) {
        this.limite = limite;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    

    
    
}
