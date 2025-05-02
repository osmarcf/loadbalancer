package com.miratech.loadbalancer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.miratech.loadbalancer.LoadBalancer.MAX_ADDRESSES;

@SpringBootTest
class LoadBalancerRandomTests extends LoadBalancerCommon {

	@BeforeEach
	public void reset() {
		loadBalancer = new LoadBalancerRandom();
	}

	@Test
	public void shouldGetAddressesRandomly() {
		for (int i = 0; i < MAX_ADDRESSES; i++) {
			LoadBalancer.AddressInstance addressInstance = new LoadBalancer.AddressInstance(ADDRESS_PREFIX + (i + 1));
			loadBalancer.add(addressInstance);
		}

		boolean isDifferent = false;
		int counter = MAX_ADDRESSES;
		while (counter > 0 && !isDifferent) { // 10 tries to check randomness
			LoadBalancer.AddressInstance addressInstance1 = loadBalancer.get();
			LoadBalancer.AddressInstance addressInstance2 = loadBalancer.get();
			isDifferent = addressInstance1 != addressInstance2;
			counter--;
		}
	}

}
