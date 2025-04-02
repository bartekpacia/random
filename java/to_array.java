import java.util.Collection;

void main() {
	List<String> namesList = List.of("alpha", "bravo", "charlie");
	Object[] namesArray_1 = namesList.toArray();
	println("--- Object[] toArray()");
	for (Object name : namesArray_1) {
		println(name);
	}
	println("--- <T> T[] toArray(T[] a)");
	String[] namesArray_2 = namesList.toArray(new String[0]);
	for (String name : namesArray_2) {
		println(name);
	}
}
