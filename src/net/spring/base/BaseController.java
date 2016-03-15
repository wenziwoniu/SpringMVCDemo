package net.spring.base;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 所有Controller的基类
 */
public abstract class BaseController {

	public static final String EXCEPTION_MESSAGE = "EXCEPTION_MESSAGE";
	public static final String FLASH_MESSAGE="FLASH_MESSAGE";
	protected final Logger logger;
	protected final ObjectMapper mapper;
	
	
	public BaseController() {
		this.logger=LoggerFactory.getLogger(this.getClass());
		this.mapper = new ObjectMapper();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(true));
		binder.registerCustomEditor(Long.class, new CustomLongEditor(true));
	}

}
