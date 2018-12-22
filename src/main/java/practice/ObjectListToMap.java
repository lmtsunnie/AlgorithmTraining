package practice;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ObjectListToMap {
    public static List<People> generatePeopleList() {
        People sunnie1 = new People();
        People sunnie2 = new People();
        People mackie1 = new People();
        People mackie2 = new People();
        sunnie1.setName("sunnie");
        sunnie1.setAge(3);
        sunnie2.setName("sunnie");
        sunnie2.setAge(4);
        mackie1.setName("mackie");
        mackie1.setAge(100);
        mackie2.setName("mackie");
        mackie2.setAge(200);

        return Lists.newArrayList(sunnie1, mackie1, sunnie2, mackie2);
    }

    /*public static User peopleToUser(People people) {
        User user = new User();
        user.setName(people.getName());
        user.setAge(people.getAge());
        return user;
    }*/

    public static Map<String, People> peopleListToMap(List<People> list) {
        /*Map<String, People> map = Maps.newHashMap()R;
        for (People people : list) {
            map.put(people.getName(), people);
        }
        return map;*/
        return list.stream().collect(Collectors.toMap(People::getName,
                e -> e /*Function.identity()*/, 
                (e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2 ));
    }

    public static List<User> peopleListToUserList(List<People> list) {
        return list.stream()
                .map(people -> UserBuilder.builder()
                        .setUserName(people.getName()).setUserAge(people.getAge()).build())
                .collect(Collectors.toList());
    }

    public static Map<String, List<People>> peopleGroupByName(List<People> list) {
        return list.stream()
                .collect(Collectors.groupingBy(People::getName));
    }

    public static void main(String[] args) {
        System.out.println("generatePeopleList()");
        System.out.println(generatePeopleList());
        System.out.println();
        System.out.println("peopleListToMap(generatePeopleList())");
        System.out.println(peopleListToMap(generatePeopleList()));
        System.out.println();
        System.out.println("peopleListToUserList(generatePeopleList())");
        System.out.println(peopleListToUserList(generatePeopleList()));
        System.out.println();
        System.out.println("peopleGroupByName(generatePeopleList())");
        System.out.println(peopleGroupByName(generatePeopleList()));
    }
}
