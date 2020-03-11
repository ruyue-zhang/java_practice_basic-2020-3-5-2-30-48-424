import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class PersonSet {
  private List<MasterNumber> masterNumbers;

  private List<Address> addresses;

  private List<Telephone> telephones;

  private List<Email> emails;

  public PersonSet(List<MasterNumber> masterNumbers,
                   List<Telephone> telephones,
                   List<Address> addresses,
                   List<Email> emails) {
    this.masterNumbers = masterNumbers;
    this.addresses = addresses;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Stream<Person> groupToPeople() {
    // TODO: group the data to Stream<Person>
    // Can use Collectors.groupingBy method
    // Can add helper method
    Map<String, List<Telephone>> telephoneMap = this.telephones.stream()
            .collect(groupingBy(Telephone::getMasterNumber)); //"1"=[...] "2"=[...]
    Map<String, List<Address>> addressMap = this.addresses.stream()
            .collect(groupingBy(Address::getMasterNumber));
    Map<String, List<Email>> emailMap = this.emails.stream()
            .collect(groupingBy(Email::getMasterNumber));
    Stream<MasterNumber> stream = masterNumbers.stream();
    return stream.map(MasterNumber::getNumber)
            .map(value -> new Person(value,
                    telephoneMap.containsKey(value) ? telephoneMap.get(value) : new ArrayList<>(),
                    addressMap.containsKey(value) ? addressMap.get(value).get(0) : null,
                    emailMap.containsKey(value) ? emailMap.get(value) : new ArrayList<>()));
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setMasterNumbers(List<MasterNumber> masterNumbers) {
    this.masterNumbers = masterNumbers;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }
}
