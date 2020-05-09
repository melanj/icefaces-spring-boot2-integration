package org.icefaces.samples.showcase.util;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.inject.Named;

import org.icefaces.application.ProductInfo;

@Named(ProductUtil.BEAN_NAME)
@ApplicationScoped
public class ProductUtil implements Serializable {
	public static final String BEAN_NAME = "productUtil";
	
	private String productInfoString;
	
	public String getProductInfo() {
		if (productInfoString == null) {
			productInfoString = new StringBuilder("Powered by ")
				.append(ProductInfo.PRODUCT)
				.append(" ").append(ProductInfo.PRIMARY).append(".")
				.append(ProductInfo.SECONDARY).append(".").append(ProductInfo.TERTIARY).toString();
				/*.append(ProductInfo.TERTIARY).append(" (revision ")
				.append(ProductInfo.REVISION).append(")").toString();*/
		}
		return productInfoString;
	}
}
