package com.playground.examples.oracle.client.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playground.examples.oracle.client.OracleClient;

@ContextConfiguration(locations = { "classpath:META-INF/spring/beans.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OracleClientTest {

	private final static Logger logger = LoggerFactory.getLogger(OracleClientTest.class);

	private Properties prop;

	@Autowired
	private OracleClient oracleClient;

	/**
	 * 
	 */
	public OracleClientTest() {
		final InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.properties");
		prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);;
		}
	}

	@Test
	public void getScheduleEventByCridAndImiTest() {
		final Map<String, Object> result = oracleClient.getScheduleEventByCridAndImi(prop.getProperty("test.crid"), prop.getProperty("test.imi"), prop.getProperty("test.country"));
		for (String key : result.keySet()) {
			logger.info(MessageFormat.format("{0}: {1}", key, result.get(key)));
		}
	}

//	@Test
	public void getVersionTest() {
		final List<Map<String, Object>> rowSet = oracleClient.getVersion();
		for (final Map<String, Object> row : rowSet) {
			for (String key : row.keySet()) {
				logger.info(MessageFormat.format("{0}: {1}", key, row.get(key)));
			}
		}
	}
}
