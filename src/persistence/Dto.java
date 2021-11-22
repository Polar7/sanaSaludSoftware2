package persistence;

/**
 * Interfaz que moldea el patron DTO
 */
public interface Dto {

    /**
     * Retorna una instruccion sql
     * @return Instruccion sql
     */
    String insert();
}
