package com.techshop.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.http.client.ClientProtocolException;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import com.techshop.web.base.Constants;
import com.techshop.web.model.CartProductModel;
import com.techshop.web.model.CheckoutInformationModel;
import com.techshop.web.model.DeliveryInformationModel;
import com.techshop.web.model.OrderProductInformation;
import com.techshop.web.service.CheckoutService;
import com.techshop.web.service.ProductService;

@ManagedBean(name="checkout")
@SessionScoped
@URLMappings(mappings={
		@URLMapping(id="delivery", pattern="/thanh-toan/thong-tin-giao-hang", viewId="/web/deliveryinformation.xhtml"),
		@URLMapping(id="payment", pattern="/thanh-toan/phuong-thuc-thanh-toan", viewId="/web/payment.xhtml"),
		@URLMapping(id="success", pattern="/thanh-toan/thanh-cong", viewId="/web/success.xhtml"),
		@URLMapping(id="fail", pattern="/thanh-toan/that-bai", viewId="/web/error.xhtml")
})
public class CheckoutController {
	
	private DeliveryInformationModel model;
	
	private List<CartProductModel> products;
	
	@EJB
	private ProductService productService;
	
	public List<CartProductModel> getProducts() {
		return products;
	}

	public void updateProducts(List<CartProductModel> products) {
		this.products = products;
	}

	private Integer deliveryFee;
	
	@EJB
	private CheckoutService checkoutService;

	@PostConstruct
	private void init() {
		model = new DeliveryInformationModel();
	}
	
	public void submitInformation() throws ClientProtocolException, IOException {
		if (model == null) {
			return;
		}
		CheckoutInformationModel dim = convert(model);
		try {
			checkoutService.saveCheckOutInformation(dim);
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constants.CONTEXT_PATH + "/thanh-toan/thanh-cong");
		}
		catch (Exception e) {
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constants.CONTEXT_PATH + "/thanh-toan/that-bai");
		}
		
		
	}
	
	private CheckoutInformationModel convert(DeliveryInformationModel dim) {
		CheckoutInformationModel cim = new CheckoutInformationModel();
		cim.setAddress(dim.getAddress());
		cim.setCity(dim.getCity());
		cim.setCompany(dim.getCompany());
		cim.setDeliveryType(dim.getDeliveryType());
		cim.setEmail(dim.getEmail());
		cim.setFullname(dim.getName());
		cim.setPhoneNumber(dim.getPhone());
		List<OrderProductInformation> list = new ArrayList<>();
		for (CartProductModel cartProductModel : this.getProducts()) {
			OrderProductInformation opi = new OrderProductInformation();
			opi.setProductId(cartProductModel.getProductInCart().getId());
			opi.setQuantity(cartProductModel.getQuantity());
			list.add(opi);
		}
		cim.setOrderDetails(list);
		return cim;
	}
	
	public void redirectToPaymentInformation() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(Constants.CONTEXT_PATH + "/thanh-toan/phuong-thuc-thanh-toan");
	}
	
	public void updateDeliveryFee() {
		if (this.model.getDeliveryType().equals("free")) {
			this.deliveryFee = 0;
		}
		else {
			this.deliveryFee = 15000;
		}
	}
	
	public DeliveryInformationModel getModel() {
		return model;
	}

	public void setModel(DeliveryInformationModel model) {
		this.model = model;
	}
	
	public Integer getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Integer deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
}
