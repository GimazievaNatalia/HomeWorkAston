package lesson_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        List<String> phones;
        if (phoneBook.containsKey(lastName)) {
            phones = phoneBook.get(lastName);
        } else {
            phones = new ArrayList<>();
            phoneBook.put(lastName, phones);
        }
        phones.add(phoneNumber);
        phoneBook.put(lastName, phones);
    }

    public List<String> get(String lastName) {
        return phoneBook.get(lastName);
    }

}

