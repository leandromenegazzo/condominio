package br.com.condominio.ejb.home;

/**
 * Created by: Leandro C. Menegazzo
 * Date: 02/09/2016.
 */
public interface Crud<T> {

    /**
     * Busca o registro na tabela mapeada pela entity T tipada
     * para esta interface.
     *
     * @param pk primary key a ser utilizada para realizar a busca.
     * @return Registro encotrado do tipo informado no argumento
     * genérico da classe.
     */
    public T findForEdit(Object pk);

    /**
     * Salva o registro, deve saber se é para persistir ou alterar.
     *
     * @param entity a ser alterada ou persistida.
     */
    public void save(T entity);

    /**
     * Remove através da primary key o registro da entity T
     * informada no argumento genérico desta interface
     *
     * @param pk primary key da entity a ser removida
     */
    public void remove(Object pk);

}
