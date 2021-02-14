package main.java.com.dlt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author denglitong
 * @date 2021/1/5
 */
public class SLF4JLogging {
	private static Logger log = LoggerFactory.getLogger(SLF4JLogging.class);

	public static void main(String[] args) {
		log.info("hello logging");
	}
}
