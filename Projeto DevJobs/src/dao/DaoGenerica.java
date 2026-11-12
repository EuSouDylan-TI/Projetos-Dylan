
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author f3l1p3
 */
public interface DaoGenerica<ObjetoGenerico> {

    public void inserir(ObjetoGenerico objt);

    public void alterar(ObjetoGenerico objt);

    public void excluir();

    public ArrayList<ObjetoGenerico> consultar();

    public ArrayList<ObjetoGenerico> dashboard();

}
