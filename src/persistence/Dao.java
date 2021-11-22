package persistence;

/**
 * Clase abstracta que moldea el patron DAO
 * @param <T> Objeto DTO
 */
public abstract class Dao <T extends Dto>
{

    /**
     * Construye una instancia DTO
     */
    protected void Dto(){}

    /**
     * Retorna una instruccion sql
     * @param data Dto de un objeto
     * @return La instuccion sql
     */
    public String insert(Dto data)
    {
        return data.insert();
    }
}
