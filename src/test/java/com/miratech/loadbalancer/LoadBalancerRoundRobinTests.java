package com.miratech.loadbalancer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.miratech.loadbalancer.LoadBalancer.MAX_ADDRESSES;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LoadBalancerRoundRobinTests extends LoadBalancerCommon {

	@BeforeEach
	public void reset() {
		loadBalancer = new LoadBalancerRoundRobin();
	}

	@Test
	public void shouldGetAddressesInRoundRobinOrder() {
		for (int i = 0; i < MAX_ADDRESSES; i++) {
			LoadBalancer.AddressInstance addressInstance = new LoadBalancer.AddressInstance(ADDRESS_PREFIX + (i + 1));
			loadBalancer.add(addressInstance);
		}

		for (int i = 0; i < MAX_ADDRESSES; i++) {
			assertEquals(ADDRESS_PREFIX + (i + 1), loadBalancer.get().address());
		}
	}

}
