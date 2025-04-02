import java.util.Collections;

void main() {
	String[] names = {"alpha", "bravo", "charlie"};

	List<String> namesList = Arrays.asList(names);
	for (String name : namesList) {
		println(name);
	}
}
