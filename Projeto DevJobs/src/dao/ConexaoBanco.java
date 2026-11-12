
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexaoBanco {

    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;

    public ConexaoBanco() {
        this.servidor = "localhost:3306";
        this.banco = "bancosql";
        this.usuario = "root";
        this.senha = "#Maestros#21";
    }

    public boolean conectar() {
        try {
            String url = "jdbc:mysql://" + servidor + "/" + banco;

            conexao = DriverManager.getConnection(
                    url,
                    usuario,
                    senha
            );

            System.out.println("Conexão com o banco estabelecida.");

            return true;

        } catch (SQLException ex) {
            System.err.println("Erro ao conectar ao banco.");
            System.err.println("Código SQL: " + ex.getErrorCode());
            System.err.println("Estado SQL: " + ex.getSQLState());
            System.err.println("Detalhes: " + ex.getMessage());

            JOptionPane.showMessageDialog(
                    null,
                    "Não foi possível conectar ao banco de dados.\n\n"
                    + "Código: " + ex.getErrorCode() + "\n"
                    + "Estado: " + ex.getSQLState() + "\n"
                    + "Motivo: " + ex.getMessage(),
                    "Erro de conexão",
                    JOptionPane.ERROR_MESSAGE
            );

            return false;
        }
    }

    public Connection getConnection() {
        return conexao;
    }
}