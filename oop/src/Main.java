import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2, "Divyarajsinh"));
        list.add(new Student(1, "Peter Parker"));

//        Collections.sort(list);
//
//        System.out.println(list);

        Collections.sort(list, new Name());

        System.out.println(list);

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Peter");
        map.put(2, "Tony");
        map.put(3, "Steve");

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }



    }
}

