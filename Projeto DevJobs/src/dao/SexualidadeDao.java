/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Sexualidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author f3l1p3
 */
public class SexualidadeDao {

    // INSERIR
    public void inserir(Sexualidade sexualidade) {
        ConexaoBanco conexaoBanco = new ConexaoBanco();

        if (!conexaoBanco.conectar()) {
            throw new RuntimeException(
                    "Não foi possível conectar ao banco de dados."
            );
        }

        String sql = "INSERT INTO sexualidade "
                   + "(descricao, sigla, status) VALUES (?, ?, ?)";

        try (Connection conexao = conexaoBanco.getConnection();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, sexualidade.getDescricao());
            comando.setString(2, sexualidade.getSigla());
            comando.setString(3, sexualidade.getStatus());

            comando.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(
                    "Erro ao inserir registro: " + ex.getMessage(), ex
            );
        }
    }

    // ALTERAR
    public void alterar(Sexualidade sexualidade) {
        ConexaoBanco conexaoBanco = new ConexaoBanco();

        if (!conexaoBanco.conectar()) {
            throw new RuntimeException(
                    "Não foi possível conectar ao banco de dados."
            );
        }

        String sql = "UPDATE sexualidade "
                   + "SET descricao = ?, sigla = ?, status = ? "
                   + "WHERE id = ?";

        try (Connection conexao = conexaoBanco.getConnection();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, sexualidade.getDescricao());
            comando.setString(2, sexualidade.getSigla());
            comando.setString(3, sexualidade.getStatus());
            comando.setInt(4, sexualidade.getId());

            comando.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(
                    "Erro ao alterar registro: " + ex.getMessage(), ex
            );
        }
    }

    // CONSULTAR TODOS OS REGISTROS
    public ArrayList<Sexualidade> consultar() {
        ArrayList<Sexualidade> lista = new ArrayList<>();

        String sql = "SELECT id, descricao, sigla, status "
                   + "FROM sexualidade ORDER BY id";

        ConexaoBanco conexaoBanco = new ConexaoBanco();

        if (!conexaoBanco.conectar()) {
            throw new RuntimeException(
                    "Não foi possível conectar ao banco de dados."
            );
        }

        try (Connection conexao = conexaoBanco.getConnection();
             PreparedStatement comando = conexao.prepareStatement(sql);
             ResultSet resultado = comando.executeQuery()) {

            while (resultado.next()) {
                Sexualidade sexualidade = new Sexualidade();

                sexualidade.setId(resultado.getInt("id"));
                sexualidade.setDescricao(
                        resultado.getString("descricao"));
                sexualidade.setSigla(
                        resultado.getString("sigla"));
                sexualidade.setStatus(
                        resultado.getString("status"));

                lista.add(sexualidade);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(
                    "Erro ao consultar registros: " + ex.getMessage(), ex
            );
        }

        return lista;
    }

    // CONSULTAR SOMENTE REGISTROS ATIVOS
    public ArrayList<Sexualidade> consultarAtivas() {
        ArrayList<Sexualidade> lista = new ArrayList<>();

        String sql = "SELECT id, descricao, sigla, status "
                   + "FROM sexualidade "
                   + "WHERE status = ? "
                   + "ORDER BY descricao";

        ConexaoBanco conexaoBanco = new ConexaoBanco();

        if (!conexaoBanco.conectar()) {
            throw new RuntimeException(
                    "Não foi possível conectar ao banco de dados."
            );
        }

        try (Connection conexao = conexaoBanco.getConnection();
             PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, "Ativo");

            try (ResultSet resultado = comando.executeQuery()) {
                while (resultado.next()) {
                    Sexualidade sexualidade = new Sexualidade();

                    sexualidade.setId(resultado.getInt("id"));
                    sexualidade.setDescricao(
                            resultado.getString("descricao"));
                    sexualidade.setSigla(
                            resultado.getString("sigla"));
                    sexualidade.setStatus(
                            resultado.getString("status"));

                    lista.add(sexualidade);
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(
                    "Erro ao consultar sexualidades ativas: "
                    + ex.getMessage(), ex
            );
        }

        return lista;
    }
}