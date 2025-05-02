package com.miratech.loadbalancer;

public interface LoadBalancerAlgorithm {
    LoadBalancer.AddressInstance get();
}
