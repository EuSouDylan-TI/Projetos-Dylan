
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 */
package dao;

import modelo.Cadastro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author f3l1p3
 */
public class CadastroDao implements DaoGenerica<Cadastro> {

    private ConexaoBanco conexao;

    public CadastroDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(Cadastro cadastro) {
    }

    @Override
    public void alterar(Cadastro cadastro) {
    }

    @Override
    public void excluir() {
    }

    public void excluirID(int id) {
    }

    @Override
    public ArrayList<Cadastro> consultar() {
        return new ArrayList<>();
    }

    public ArrayList<Cadastro> consultar(String str) {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Cadastro> dashboard() {
        return new ArrayList<>();
    }
}
