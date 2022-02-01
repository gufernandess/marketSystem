/**
 * Interface que implementa as listas de funcionário 
 * e de conta disponíveis no sitema.
 */

public interface Listing {

    public boolean addObject(Object object);

    public boolean deleteObject(int id);

    public String toString();
}
