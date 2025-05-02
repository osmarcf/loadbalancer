package com.miratech.loadbalancer;

import org.springframework.stereotype.Service;

@Service
public class LoadBalancerRandom extends LoadBalancer implements LoadBalancerAlgorithm {

    public AddressInstance get() {
        int index = (int) (Math.random() * MAX_ADDRESSES) % addresses.size();
        return addresses.get(index);
    }

}
