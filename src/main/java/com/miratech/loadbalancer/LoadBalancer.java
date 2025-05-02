package com.miratech.loadbalancer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LoadBalancer {

    public static final int MAX_ADDRESSES = 10;

    List<AddressInstance> addresses = new CopyOnWriteArrayList<>();

    public void add(AddressInstance addressInstance) {

        if (addresses.size() >= MAX_ADDRESSES) {
            throw new RuntimeException("Instances exceeded");
        }

        if (addresses.contains(addressInstance)) {
            throw new RuntimeException("Duplicated instances are not allowed");
        }

        addresses.add(addressInstance);
    }

    public AddressInstance get() {
        throw new IllegalArgumentException("Invalid algorithm");
    }

    public record AddressInstance (String address) {}

}
