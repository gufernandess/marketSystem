import java.util.List;

public abstract class Listing {

    private List<Object> list;

    public Listing(List<Object> list) {}

    public boolean addObject(Object object) {}

    public boolean deleteObject(int index) {}

    public String toString() {}
}
