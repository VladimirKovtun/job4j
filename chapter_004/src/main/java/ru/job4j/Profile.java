package ru.job4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
    }
    public static List<Address> collectNew(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> profile.address)
                .distinct().sorted(Comparator.comparing(Address::getCity))
                .collect(Collectors.toList());
    }
}
