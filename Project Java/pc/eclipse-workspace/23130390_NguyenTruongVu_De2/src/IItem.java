
public abstract class IItem {
public abstract boolean checkProduct(Item that);
public abstract IItem sortByTitle();
public abstract IItem insert(Item that);
public abstract int total(String name);
public abstract String pL(String name);
}
