package com.ynr.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ynr.springboot.entities.Entry;
import com.ynr.springboot.entities.User;
import com.ynr.springboot.service.EntryService;
import com.ynr.springboot.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyDairyController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EntryService entryService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private HttpSession session;

	@GetMapping("/")
	public String homePage()
	{
		return "loginPage";
	}
	
	@GetMapping("register")
	public String registerPage()
	{
		return "registerPage";
	}
	
	@PostMapping("registeruser")
	public String registerUser(@ModelAttribute("user")User user)
	{
		userService.saveUser(user);
		String view = "registeredSuccess";
		return view;
	}
	
	@PostMapping("authantication")
	public String authantication(@ModelAttribute("user")User user,Model model)
	{
		User user1 = userService.findUserByUsername(user.getUsername());
		
		String view ="loginFailed";
		if(user1!=null && user1.getPassword().equals(user.getPassword()))
		{
			 view = "userHomePage";
			 session.setAttribute("user", user1);
			 model.addAttribute("user",user1);
			 
			 List<Entry> entries=null;
			 
			 try {
				 entries=entryService.findByUserid(user1.getId());
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
			 model.addAttribute("entrieslist",entries);
		}
		return view;
	}
	
	@GetMapping("passwordreset")
	public String passwordReset()
	{
		String view = "passwordresetPage";
		return view;
	}
	
	@PostMapping("updatepassword")
	public String updatepassword(@ModelAttribute("user")User user)
	{
       userService.updateUser(user);		
		String view ="passwordResetSuccess";
		return view;
	}
	
	@GetMapping("signout")
	public String signOut()
	{
		session.invalidate();
		return "loginPage";
	}
	
	@GetMapping("showAddEntryPage")
	public String showaddEntry()
	{
		return "addEntryPage";
	}
	
	@PostMapping("addentry")
	public String addEntry(@ModelAttribute("entry")Entry entry,Model model)//here entry was came from web so we need to store it in database
	{
		String view ="userHomePage";
		
		entryService.saveEntry(entry);
		User user1=(User)session.getAttribute("user");
		
          List<Entry> entries=null;
		
		try {
			entries=entryService.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("entrieslist", entries);
		
		return view;
	}
	@GetMapping("viewentry")
	public String viewEntry(@RequestParam("id")int id,Model model)
	{
		String view = "viewEntryPage";
		Entry entry = entryService.findById(id);
		
		model.addAttribute("entry",entry);
		
		return view;
	}
	
	@GetMapping("userhome")
	public String userhomepage(Model model)
	{
		
		String viewname="userHomePage";
		User user1=(User)session.getAttribute("user");
		
		List<Entry> entries=null;
		
		try {
			entries=entryService.findByUserid(user1.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("entrieslist", entries);
		
		return viewname;
	}
	
	@GetMapping("updateentry")
	public String updateEntry(@RequestParam("id")int id,Model model)
	{
		String view = "updateEntrypage";
		Entry entry = entryService.findById(id);
		
		model.addAttribute("entry",entry);
		return view;
	}
	
	@PostMapping("updateentryInDB")
	public String updateEntryinDB(@ModelAttribute("entry")Entry entry,Model model)
	{
		entryService.updateEntry(entry);
		String viewname="userHomePage";
		User user1=(User)session.getAttribute("user");
		
		 List<Entry> entries=null;
			
			try {
				entries=entryService.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("entrieslist", entries);
		
		return viewname;
	}
	
	@GetMapping("deleteentry")
	public String deleteEntry(@RequestParam("id")int id,Model model)
	{
		Entry entry = entryService.findById(id);
		
		entryService.deleteEntry(entry);
		
		String viewname="userHomePage";
		User user1=(User)session.getAttribute("user");
		
		 List<Entry> entries=null;
			
			try {
				entries=entryService.findByUserid(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("entrieslist", entries);
		
		return viewname;
	}
	
}
