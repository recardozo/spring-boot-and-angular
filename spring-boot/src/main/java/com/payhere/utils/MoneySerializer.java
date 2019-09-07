package com.payhere.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneySerializer extends JsonDeserializer<BigDecimal> {

	@Override
	public BigDecimal deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		// put your desired money style here
		String floatString = parser.getText();
		if (floatString.contains(",")) {
			floatString = floatString.replace(",", ".");
		}
		return BigDecimal.valueOf(Double.parseDouble(floatString)).setScale(2, RoundingMode.HALF_UP);
	}

}