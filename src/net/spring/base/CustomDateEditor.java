package net.spring.base;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;

import net.spring.utils.DateUtils;

import org.springframework.util.StringUtils;

public class CustomDateEditor extends PropertyEditorSupport{
	

	
	private final boolean allowEmpty;

	private final int exactDateLength;
	
	public CustomDateEditor(boolean allowEmpty) {
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	public CustomDateEditor( boolean allowEmpty, int exactDateLength) {
		this.allowEmpty = allowEmpty;
		this.exactDateLength = exactDateLength;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (this.allowEmpty && !StringUtils.hasText(text)) {
			// Treat empty String as null value.
			setValue(null);
		}
		else if (text != null && this.exactDateLength >= 0 && text.length() != this.exactDateLength) {
			throw new IllegalArgumentException(
					"Could not parse date: it is not exactly" + this.exactDateLength + "characters long");
		}
		else {
			try {
				setValue(DateUtils.parseDate(text));
			}
			catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
			}
		}
	}
}
