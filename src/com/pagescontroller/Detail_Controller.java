package com.pagescontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.detail.info.Detail;

import sun.misc.Contended;


@Controller
public class Detail_Controller {
	//
	private List<Detail> list;
	private int number;
	//Constructor
	public Detail_Controller(){
		//
		this.list = new ArrayList<Detail>();
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value={"/welcome.do"})
	public String firstTime(ModelMap model,@ModelAttribute("SpringWeb")Detail detail){
		model.addObject("change_action", "save");
		model.addObject("button_text", "Submit");
		model.addAttribute("command", new Detail());
		model.addObject("list", list);
		return "post_detail";
	}
	
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value={"save"})
	public ModelAndView Increment(@ModelAttribute("SpringWeb")Detail detail,ModelMap model){
		model.addObject("change_action", "save");
		model.addObject("button_text", "Submit");
		model.addAttribute("command", new Detail());
		list.add(detail);
		model.addObject("list", list);
		
		return new ModelAndView("post_detail");
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping("edit")
	 public ModelAndView edit_Detail(ModelMap model,HttpServletRequest request) {
	 
		number = Integer.parseInt(request.getParameter("edt"));
		model.addObject("command", new Detail(list.get(number).getDate(),list.get(number).getComment() ));
		model.addObject("change_action", "done");
		model.addObject("button_text", "Edit/Save");
		model.addObject("list", list);
	 
		return new ModelAndView("post_detail");
	 }
	
	@SuppressWarnings("deprecation")
	@RequestMapping("delete")
	public ModelAndView delete_Detail(ModelMap model,HttpServletRequest request) {
		
		model.addAttribute("command", new Detail());
		model.addObject("change_action", "save");
		list.remove(Integer.parseInt(request.getParameter("det")));
		model.addObject("list", list);
		model.addObject("button_text", "Submit");
		
		return new ModelAndView("post_detail");
	 }
	
	@SuppressWarnings("deprecation")
	@RequestMapping("done")
	public ModelAndView edit_save_Detail(@ModelAttribute("SpringWeb")Detail detail,ModelMap model) {
	
		model.addAttribute("command", new Detail());
		list.set(number, detail);
		model.addObject("change_action", "save");
		model.addObject("button_text", "Submit");
		model.addObject("list", list);
		
		return new ModelAndView("post_detail");
	 }
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value ="disable")
	public ModelAndView disable_link(HttpServletRequest request,ModelMap model){
		
		model.addAttribute("command", new Detail());
		model.addObject("change_action", "save");
		model.addObject("button_text", "Submit");
		model.addObject("dis", Integer.parseInt(request.getParameter("dis")));
		model.addObject("list", list);
		
		return new ModelAndView("post_detail");
	}


}
