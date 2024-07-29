package main.classes;

public interface Searchable {
    boolean matches(SearchByType searchByType, Object key);
}
