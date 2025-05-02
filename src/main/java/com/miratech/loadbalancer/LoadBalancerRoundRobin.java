package com.miratech.loadbalancer;

import org.springframework.stereotype.Service;

@Service
public class LoadBalancerRoundRobin extends LoadBalancer implements LoadBalancerAlgorithm {

    int index = 0;

    public AddressInstance get() {
        AddressInstance result = addresses.get(index);
        index = (index + 1) % addresses.size();
        return result;
    }

}
