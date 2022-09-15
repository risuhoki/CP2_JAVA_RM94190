package br.com.fiap;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController implements Initializable{

@FXML TextField textFieldTitular;
@FXML TextField textFieldNumero;
@FXML ChoiceBox<String> choiceBoxTpConta;
@FXML ChoiceBox<String> choiceBoxAtiva;
@FXML TextField textFieldLimite;
@FXML TextField textFieldSaldo;
@FXML Button buttonConfirmar;
@FXML private ListView<Usuario> listView;

private List<Usuario> listaAtiva = new ArrayList<>();

private List<Usuario> lista = new ArrayList<>();

public void confirmar(){
    try{
        var usuario = carregarUsuarioCadastro();
            lista.add(usuario);

        mostrarAlerta("Conta Cadastrada com Sucesso");

        limparDados();
        listView.getItems().clear();
        listView.getItems().addAll(lista);
    }catch(Exception erro){
        Alert mensagemErro = new Alert(AlertType.ERROR);
        mensagemErro.setContentText("Erro");
        mensagemErro.setTitle("Erro numérico");
        mensagemErro.show();
    }
}

public void limparDados(){
    textFieldTitular.setText("");
    textFieldNumero.setText("");
    textFieldLimite.setText("");
    textFieldSaldo.setText("");
}

private Usuario carregarUsuarioCadastro(){
    String titular = textFieldTitular.getText();
    Double numero = Double.valueOf(textFieldNumero.getText());
    String tpConta = choiceBoxTpConta.getValue();
    String ativa = choiceBoxAtiva.getValue();
    Double limite = Double.valueOf(textFieldLimite.getText());
    Double saldo = Double.valueOf(textFieldSaldo.getText());

    Usuario usuario = new Usuario(titular,numero,tpConta,ativa,limite,saldo);
    return usuario;
}

public void mostrarAlerta(String mensagem){
    Alert alerta = new Alert(AlertType.INFORMATION);
    alerta.setContentText("Conta cadastrada com sucesso");
    alerta.show();
}

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
    List<String> tpContass = new ArrayList<>();
    tpContass.add("Corrente");
    tpContass.add("Poupança");
    tpContass.add("Salário");
    choiceBoxTpConta.getItems().addAll(tpContass);
    
    List<String> ativoOuDesativo = new ArrayList<>();
    ativoOuDesativo.add("Sim");
    ativoOuDesativo.add("Não");
    choiceBoxAtiva.getItems().addAll(ativoOuDesativo);
}

public void ordenarPorTitular(){
        lista.sort((o1, o2) -> o1.getTitular().compareTo(o2.getTitular()));
        atualizarLista();
}

public void ordenarPorNum(){
        lista.sort((o1, o2) -> Double.compare(o1.getNumero(), o2.getNumero()));
        atualizarLista();
}

public void ordenarPorSaldo(){
    lista.sort((o1, o2) -> Double.compare(o1.getSaldo(), o2.getSaldo()));
    atualizarLista();
}

public void ordenarPorAtiva(){
    for(Usuario ativo:lista){ 
        if(ativo.getAtiva().equals("Sim")){
            listaAtiva.add(ativo);
        }
    }
    listView.getItems().clear();
    listView.getItems().addAll(listaAtiva);
}

private void atualizarLista(){
    listView.getItems().clear();
    listView.getItems().addAll(lista);
}

}