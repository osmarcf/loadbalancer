package com.miratech.loadbalancer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.miratech.loadbalancer.LoadBalancer.MAX_ADDRESSES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LoadBalancerCommonTests extends LoadBalancerCommon {

	@BeforeEach
	public void reset() {
		loadBalancer = new LoadBalancerRandom(); // could be any
	}

	@Test
	public void shouldCreateOneInstance() {
		LoadBalancer.AddressInstance addressInstance = new LoadBalancerRandom.AddressInstance(ADDRESS_PREFIX + "1");
		loadBalancer.add(addressInstance);

		LoadBalancerRandom.AddressInstance persistedAddressInstance = loadBalancer.get();
		assertEquals(ADDRESS_PREFIX + "1", persistedAddressInstance.address());
	}

	@Test
	public void shouldCreateInstancesExactlyOnTheLimitWithNoErrors() {
		for (int i = 0; i < MAX_ADDRESSES; i++) {
			LoadBalancer.AddressInstance addressInstance = new LoadBalancerRandom.AddressInstance(ADDRESS_PREFIX + (i + 1));
			loadBalancer.add(addressInstance);
		}
	}

	@Test
	public void shouldThrowExceptionInstancesExceeded() {
		for (int i = 0; i < MAX_ADDRESSES; i++) {
			LoadBalancer.AddressInstance addressInstance = new LoadBalancer.AddressInstance(ADDRESS_PREFIX + (i + 1));
			loadBalancer.add(addressInstance);
		}

		LoadBalancer.AddressInstance addressInstance = new LoadBalancer.AddressInstance(ADDRESS_PREFIX + "11");

		assertThrows(RuntimeException.class, () -> {
			loadBalancer.add(addressInstance);
		});
	}

}
