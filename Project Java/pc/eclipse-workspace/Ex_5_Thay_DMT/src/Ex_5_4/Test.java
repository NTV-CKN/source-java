package Ex_5_4;

public class Test {
public static void main(String[] args) {
	AncestorTree at = new AncestorTree("Vu", 2005, new AncestorTree("Nguyen",1971, new AncestorTree("Thuat" , 1945, new AncestorTree("kk", 0, new AncestorTree(), new AncestorTree()), new AncestorTree("sdd", 2, new AncestorTree(), new AncestorTree())), new AncestorTree("Hien", 1947, new AncestorTree() , new AncestorTree())), new AncestorTree("Trang", 1972, new AncestorTree("Muu", 1945, new AncestorTree(), new AncestorTree()), new AncestorTree("Ngoai", 1945, new AncestorTree(), new AncestorTree())));
	AncestorTree at2 = new AncestorTree("V", 123, new AncestorTree("Nguyen", 12345, new AncestorTree(), new AncestorTree()), new AncestorTree("Trang", 567, new AncestorTree(), new AncestorTree()));
	
	System.out.println(at);
	
}
}
