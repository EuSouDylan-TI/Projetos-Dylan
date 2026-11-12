/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Candidato;

/**
 *
 * @author f3l1p3
 */
public class CandidatoDao {
    public boolean inserir(Candidato candidato) {

        ConexaoBanco conexaoBanco = new ConexaoBanco();

        if (!conexaoBanco.conectar()) {
            return false;
        }

        String sql = "INSERT INTO candidato ("
                + "nome, cpf, nascimento, email, senha, telefone, ID_Genero, "
                + "cep, logradouro, numero, complemento, bairro, cidade, uf, "
                + "curso, instituicao, escolaridade, cargo_desejado, "
                + "area_interesse, nivel_profissional, tipo_trabalho, "
                + "resumo, linguagens, github, linkedin"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection conexao = conexaoBanco.getConnection();

            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, candidato.getNome());
            comando.setString(2, candidato.getCpf());
            comando.setString(3, candidato.getNascimento());
            comando.setString(4, candidato.getEmail());
            comando.setString(5, candidato.getSenha());
            comando.setString(6, candidato.getTelefone());
            if (candidato.getSexualidade() != null && candidato.getSexualidade().getId() > 0) {
                comando.setInt(7, candidato.getSexualidade().getId());
                } else {
                comando.setNull(7, java.sql.Types.INTEGER);
                }

            comando.setString(8, candidato.getCep());
            comando.setString(9, candidato.getLogradouro());
            comando.setString(10, candidato.getNumero());
            comando.setString(11, candidato.getComplemento());
            comando.setString(12, candidato.getBairro());
            comando.setString(13, candidato.getCidade());
            comando.setString(14, candidato.getUf());

            comando.setString(15, candidato.getCurso());
            comando.setString(16, candidato.getInstituicao());
            comando.setString(17, candidato.getEscolaridade());

            comando.setString(18, candidato.getCargoDesejado());
            comando.setString(19, candidato.getAreaInteresse());
            comando.setString(20, candidato.getNivelProfissional());
            comando.setString(21, candidato.getTipoTrabalho());
            comando.setString(22, candidato.getResumo());
            comando.setString(23, candidato.getLinguagens());

            comando.setString(24, candidato.getGithub());
            comando.setString(25, candidato.getLinkedin());

            int resultado = comando.executeUpdate();

            comando.close();
            conexao.close();

            return resultado > 0;

       } catch (SQLException e) {
    e.printStackTrace();
    javax.swing.JOptionPane.showMessageDialog(
            null,
            "Erro SQL: " + e.getMessage(),
            "Detalhes do erro",
            javax.swing.JOptionPane.ERROR_MESSAGE
    );
    return false;
       }
  
    }
    public boolean verificarSeExiste(String email, String senha) {
    String sql = "SELECT * FROM candidato WHERE email = ? OR senha = ?";
    ConexaoBanco conexaoBanco = new ConexaoBanco();
    
    try (Connection conexao = conexaoBanco.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);) {
        
        stmt.setString(1, email);
        stmt.setString(2, senha);
        
        try (java.sql.ResultSet rs = stmt.executeQuery()) {
            return rs.next(); 
        }
        
    } catch (java.sql.SQLException e) {
        System.out.println("Erro ao verificar duplicidade: " + e.getMessage());
        return false;
    }
}
}
