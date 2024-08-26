package custom_collections;

public interface CRUDCollection<T> {
    public void add(T o);
    public void remove(T o);
    public T get(int index);
}
