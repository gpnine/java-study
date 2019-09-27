package com.zcl;

import com.spi.SPIService;
import org.junit.Test;
import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * web .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-27 .
 */
public class TestSpi {

	@Test
	public void testSpi() {
		Iterator<SPIService> providers = Service.providers(SPIService.class);
		ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

		while (providers.hasNext()) {
			SPIService ser = providers.next();
			ser.execute();
		}
		System.out.println("--------------------------------");
		Iterator<SPIService> iterator = load.iterator();
		while (iterator.hasNext()) {
			SPIService ser = iterator.next();
			ser.execute();
		}
	}
}
