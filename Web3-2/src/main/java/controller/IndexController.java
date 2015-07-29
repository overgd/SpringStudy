package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Item;
import logic.Shop;

public class IndexController implements Controller {

	private Shop shopService;

	public Shop getShopService() {
		return shopService;
	}

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {

		List<Item> itemList = this.shopService.getItemList();
//		if(itemList == null){
//			System.out.println("itemlist isnull");
//		}else{
//			System.out.println("itemlist is not null");
//			System.out.println("size:"+itemList.size());
//		}
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList); //검색결과 저장

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addAllObjects(model);
		
		return modelAndView;
	}

}
