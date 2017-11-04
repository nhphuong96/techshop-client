package com.techshop.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@ManagedBean
@ViewScoped
@URLMapping(id="checkout", pattern="/thanh-toan/thong-tin-giao-hang", viewId="/web/deliveryinformation.xhtml")
public class CheckoutController {

}
