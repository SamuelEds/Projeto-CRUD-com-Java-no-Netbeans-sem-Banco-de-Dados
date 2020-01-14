
package model;

import java.io.File; //Responsável por importar o pacote "File"
import java.io.FileWriter; //Responsável por importar o pacote "FileWriter"
import java.io.IOException; //Responsável por importar o pacote "IOException"
import java.io.PrintWriter; //Responsável por importar o pacote "PrintWriter"
import java.util.logging.Level; //Responsável por importar o pacote de Exception "logging.level"
import java.util.logging.Logger; //Responsável por importar o pacote de Exception "logging.Logger"
import javax.swing.JOptionPane; //Responsável por importar o pacote "JOptionPane"

public class usuario {
    //Esse campo é responsável por criar variáveis que irão atuar com os dados da interface
     String nome; //Cria a variável "nome" do tipo "String" 
     String email; //Cria a variável "email" do tipo "String" 
     String senha; //Cria a variável "senha" do tipo "String" 
     
     
    //Esse campo é responsável por criar "Pontes" entre as variáveis da interface e as variáveis de cima.
    public String getNome() { //Essa função irá receber dados (o nome do usuário) de algum lugar (No caso irá receber da interface)
        return nome;
    }

    public void setNome(String nome) { //Essa função irá mudar os dados (o nome do usuário) de algum lugar (No caso irá receber da interface) e assim
        this.nome = nome;              //por diante com os resto.
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
    
    public void cadastrar(){ //Função que irá cadastrar o usuário
        try {
            FileWriter fw = new FileWriter("../CRUDsemBancoDados/Usuarios/Usuario"+this.nome+".txt",false); //Essa linha irá criar um arquivo "txt" (do tipo texto) no determinado caminho que está entre ""
            PrintWriter pw = new PrintWriter(fw); //Essa linha de comando irá dizer onde deve escrever os dados
            
            pw.println(this.nome); //Passando os dados que a variável "nome" possui e escrevê-lo
            pw.println(this.email);//Passando os dados que a variável "email" possui e escrevê-lo
            pw.println(this.senha);//Passando os dados que a variável "senha" possui e escrevê-lo
            
            pw.flush(); //Comando para começar a escrever
            
            pw.close(); //Fecha a função PrintWriter
            fw.close(); //Fecha a função FileWriter 
            
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!"); //Exibe uma mensagem em uma caixa
        } catch (IOException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizar(){ //Função para Atualizar (os comandos são os mesmos que o da função "cadastrar")
        try {
            FileWriter fw = new FileWriter("../CRUDsemBancoDados/Usuarios/Usuario"+this.nome+".txt",false);
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println(this.nome);
            pw.println(this.email);
            pw.println(this.senha);
            
            pw.flush();
            
            pw.close();
            fw.close();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!");
        } catch (IOException ex) {
            Logger.getLogger(usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String nome){ //Função para deletar a conta (no caso ele deleta o arquivo)
        File f = new File("../CRUDsemBancoDados/Usuarios/Usuario"+nome+".txt"); //Comando "File" vai receber o arquivo no determinado caminho
        f.delete(); //Irá deletar o arquivo
        JOptionPane.showMessageDialog(null,"Conta deletada com Sucesso!!"); //Mostra uma mensagem em uma caixa de diálogo
    }
}
