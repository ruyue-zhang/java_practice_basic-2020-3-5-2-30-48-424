
import entity.MasterNumber;
import entity.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    PersonService personService = new PersonService();
    //TODO: print Person data that masterNumber is 1 and 2
    // print Person data that masterNumber is 3
    Stream<Person> personByMasterNumbers1andNumber2 = personService.getPersonByMasterNumbers(Arrays.asList(
            new MasterNumber("1"), new MasterNumber("2")));
    System.out.println("编号为1和2的用户详细信息：");
    personByMasterNumbers1andNumber2.forEach(System.out::println);

    Stream<Person> personByMasterNumber3 = personService.getPersonByMasterNumbers(Collections.singletonList(new MasterNumber("3")));
    System.out.println("编号为3的用户详细信息：");
    personByMasterNumber3.forEach(System.out::println);
  }

}
