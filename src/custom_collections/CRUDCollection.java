package custom_collections;

import java.util.Collection;

public interface CRUDCollection<T> {
    public void add(T o);
    public void remove(int index);
    public T get(int index);
    void addAll(Collection<? extends T> c);
}
