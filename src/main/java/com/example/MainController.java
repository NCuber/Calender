package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.*;

@Controller
public class MainController {
	private AnnotationConfigApplicationContext ctx;
	private MemberInfo memberInfo;
	private MemoInfo mInfo;
	private CalenderInfo cInfo;
	private MemoSearch mSearch;
	private CalenderSearch cSearch;
	
	
	Member userid = null;

	
	public MainController()
	{
		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		memberInfo = (MemberInfo)ctx.getBean("mInfo");
		mInfo = (MemoInfo)ctx.getBean("memoinfo");
		cInfo = (CalenderInfo)ctx.getBean("cInfo");
		mSearch = (MemoSearch)ctx.getBean("memoSearch");
		cSearch = (CalenderSearch)ctx.getBean("cSearch");
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
//	Member
	
	@GetMapping(value="/login")
	public String login(Model model)
	{
		return "login";
	}
	
	@RequestMapping(value="/logincheck", method = {RequestMethod.POST})
	public String logincheck(Model model, @RequestParam(value = "ID", required = true) String id,
			@RequestParam(value = "PW", required = false) String pw) throws IOException
	{
		if ((userid = memberInfo.login(id, pw)) != null)
		{
			return "redirect:/calender";
		}

		else
		{
			return "redirect:/login";
		}
			
	}
	
	@GetMapping(value="/register") // 나중에 제거 
	public String register(Model model)
	{
		return "register";
	}
	
	@RequestMapping(value="/registercheck", method = {RequestMethod.POST})
	public String registercheck(RegisterRequest regReq)
	{

		MemberRegisterService regSvc = (MemberRegisterService)ctx.getBean("memberRegSvc");
		int result = regSvc.regist(regReq);
		
		if (result > 0)
		{
			return "register";
		}
		else
		{
			return "refresh";
		}
		
		
	}

	@RequestMapping(value="/logout", method = {RequestMethod.GET})
	public String logout(Model model)
	{
		userid = null;
		return "redirect:/login";
	}

	
	
	@GetMapping(value="/logininfo") // 나중에 제거 
	public String logininfo(Model model)
	{
		model.addAttribute("user", userid);
		return "logininfo";
	}

	@GetMapping(value="/modifyuser") // 나중에 제거 
	public String modifyuser(Model model)
	{
		model.addAttribute("user", userid);
		return "modifyuser";
	}
	
	@RequestMapping(value="/modifyd", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyd(@RequestParam(value = "PASSWORD", required = false) String password,
			@RequestParam(value = "CONFIRMPASSWORD", required = false) String confirm,
			@RequestParam(value = "PHONE", required = false) String phone,
			@RequestParam(value = "ADDRESS", required = false) String address) throws IOException
	{
		if(password != "" && password != null)
		{
			if(password.equals(confirm))
				memberInfo.changepw(userid, password);
		}
		
		memberInfo.changead(userid, address);
		memberInfo.changeph(userid, phone);
		
		return "refresh";
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////////////////////////
//Memo
	
	@GetMapping(value="/memo") // 나중에 제거 
	public String memo(Model model, @RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "important", required = false) boolean important)
	{
		String text;
		if (userid != null)
		{
			text = userid.getName() + "님 메모 사용중";
		}
		else
		{
			text = "로그인에 실패하셨습니다.";
			return "redirect:/login";
		}

		List<Memo> mlist;
		if(word != null)
		{
			mlist = mSearch.searchWord(word, userid.getid());
		}
		else
		{
			if(date != null)
			{
				mlist = mSearch.searchDate(date, userid.getid());
			}
			else
			{
				if(important == true)
				{
					mlist = mSearch.searchImportant(userid.getid());
				}
				else
				{
					mlist = mInfo.printlist(userid.getid());
				}
			}
		}
		model.addAttribute("mlist", mlist);
		model.addAttribute("text", text);
		return "memolayouts";
	}
	
	@GetMapping(value="/memoinfo") // 나중에 제거 
	public String memoinfo(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{		
		Memo memo = mInfo.print(id);
		List<String> value = new ArrayList<String>();
		memo.setValue(memo.getValue().replace("\n", "<br>"));
		value = Arrays.asList(memo.getValue().split("<br>"));
		model.addAttribute("value", value);
		model.addAttribute("memo", memo);
		return "memoinfo";
	}
	
	@GetMapping(value="/memodelete") // 나중에 제거 
	public String memodelete(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{		
		mInfo.delete(id);
		return "refresh";
	}

	
	@GetMapping(value="/memoform") // 나중에 제거 
	public String memoform(Model model) throws IOException
	{		
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		model.addAttribute("date", date);
		return "memoform";
	}

	@RequestMapping(value="/modifymemo", method = {RequestMethod.GET}) // 나중에 제거 
	public String modifymemo(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{
		Memo memo = mInfo.print(id);
		model.addAttribute("memo", memo);
		return "modifymemo";
	}
	
	@RequestMapping(value="/modifydmemo", method = {RequestMethod.POST})
	public String modifydmemo(Model model,@RequestParam(value = "key", required = true) int key, @RequestParam(value = "important", required = false) boolean important, @RequestParam(value = "value", required = true) String value) throws IOException
	{
		if(important != true)
			important = false;
		mInfo.update(value, important, key);
		return "refresh";
	}
	
	
	
	
	
	
	
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////////////////////////	
////////////////////////////////////////////////////////////////////////////////////////////////////
//Calender
	
	
	@GetMapping(value="/calender") // 나중에 제거 
	public String calender(Model model, @RequestParam(value = "word", required = false) String word,
			@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "complete", required = false) boolean complete)
	{
		String text;
		if (userid != null)
		{
			text = userid.getName() + "님 캘린더 사용중";
		}
		else
		{
			text = "로그인에 실패하셨습니다.";
			return "redirect:/login";
		}
		
		
		List<Calender> clist;
		
		if(word != null)
		{
			clist = cSearch.searchWord(word, userid.getid());
		}
		else
		{
			if(date != null)
			{
				clist = cSearch.searchDate(date, userid.getid());
			}
			else
			{
				if(complete == true)
				{
					clist = cSearch.searchComplete(userid.getid());
				}
				else
				{
					clist = cInfo.printlist(userid.getid());
				}
			}
		}
		model.addAttribute("clist", clist);
		model.addAttribute("text", text);
		return "calenderlayouts";
	}
	
	@GetMapping(value="/calenderinfo") // 나중에 제거 
	public String calenderinfo(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{		
		Calender calender = cInfo.print(id);
		List<String> value = new ArrayList<String>();
		calender.setValue(calender.getValue().replace("\n", "<br>"));
		value = Arrays.asList(calender.getValue().split("<br>"));
		model.addAttribute("value", value);
		model.addAttribute("calender", calender);
		return "calenderinfo";
	}

	
	
	
	
	
	@RequestMapping(value="/modifycalender", method = {RequestMethod.GET}) // 나중에 제거 
	public String modifycalender(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{
		Calender calender = cInfo.print(id);
		model.addAttribute("calender", calender);
		return "modifycalender";
	}
	
	@RequestMapping(value="/modifydcalender", method = {RequestMethod.POST})
	public String modifydcalender(Model model, @RequestParam(value = "key", required = true) int key,@RequestParam(value = "value", required = true) String value,@RequestParam(value = "sdate", required = true) String sdate,@RequestParam(value = "edate", required = true) String edate) throws IOException
	{
		LocalDate ssdate = LocalDate.parse(sdate, DateTimeFormatter.ISO_DATE);
		LocalDate eedate = LocalDate.parse(edate, DateTimeFormatter.ISO_DATE);
		cInfo.update(value, ssdate, eedate, key);
		return "refresh";
	}
	@GetMapping(value="/calenderform") // 나중에 제거 
	public String calenderform(Model model) throws IOException
	{		
		return "calenderform";
	}
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/memowrite", method = RequestMethod.POST)
	public String memowrite(@RequestParam("file") List<MultipartFile> multipartFile, @RequestParam(value = "value", required = true) String value, @RequestParam(value = "important", required = false) boolean important) throws IOException {
		for(int i = 0; i < 5; i++)
		{
			File fold = new File("/upload");
			
			if(!fold.exists())
				fold.mkdir();
			if(i == multipartFile.size()) break;
			MultipartFile one = multipartFile.get(i);
			if (one.isEmpty())	break;
			
			File targetFile = new File("/upload/" + one.getOriginalFilename());
			try {
				InputStream fileStream = one.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				value = value + "\n *file:" + one.getOriginalFilename();
				System.out.println("성공");
			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				e.printStackTrace();
			}
		}
		if(important != true)
			important = false;
		mInfo.insert(value, important, userid.getid());
		return "refresh";

	}
	@RequestMapping(value = "/calenderwrite", method = RequestMethod.POST)
	public String calenderwrite(@RequestParam("file") List<MultipartFile> multipartFile, @RequestParam(value = "value", required = true) String value,@RequestParam(value = "sdate", required = true) String sdate,@RequestParam(value = "edate", required = true) String edate) throws IOException
	{
		LocalDate ssdate = LocalDate.parse(sdate, DateTimeFormatter.ISO_DATE);
		LocalDate eedate = LocalDate.parse(edate, DateTimeFormatter.ISO_DATE);
		for(int i = 0; i < 5; i++)
		{
			File fold = new File("/upload");
			
			if(!fold.exists())
				fold.mkdir();
			if(i == multipartFile.size()) break;
			MultipartFile one = multipartFile.get(i);
			if (one.isEmpty())	break;
			
			File targetFile = new File("/upload/" + one.getOriginalFilename());
			try {
				InputStream fileStream = one.getInputStream();
				FileUtils.copyInputStreamToFile(fileStream, targetFile);
				value = value + "\n *file:" + one.getOriginalFilename();
				System.out.println("성공");
			} catch (IOException e) {
				FileUtils.deleteQuietly(targetFile);
				e.printStackTrace();
			}
		}
		cInfo.insert(ssdate, eedate, value, userid.getid());
		return "refresh";

	}
	@RequestMapping(value = "/download", method = {RequestMethod.GET})
	public String download(@RequestParam("name") String name) throws IOException {
		name = name.substring(name.lastIndexOf(":") + 1);
		
		File fold = new File("/download");
		
		if(!fold.exists())
			fold.mkdir();
		
		File one = new File("/upload/" + name);
		File targetFile = new File("/download/" + name);
		
		FileInputStream fis = new FileInputStream(one);
		FileOutputStream fos = new FileOutputStream(targetFile);
		
		FileChannel fi = fis.getChannel();
		FileChannel fo = fos.getChannel(); 
		
		long size = fi.size();
		fi.transferTo(0, size, fo);
		System.out.println("다운 완료 - " + name);
		fo.close();
		fi.close();
		fos.close();
		fis.close();
		return "refresh";

	}

	@GetMapping(value="/calenderdelete") // 나중에 제거 
	public String calenderdelete(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{		
		cInfo.delete(id);
		return "refresh";
	}
	@GetMapping(value="/calendercomplete") // 나중에 제거 
	public String calendercomplete(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{		
		cInfo.isComplete(cInfo.print(id), true);
		return "refresh";
	}
	@GetMapping(value="/calendernotcomplete") // 나중에 제거 
	public String calendernotcomplete(Model model, @RequestParam(value = "id", required = true) int id) throws IOException
	{		
		cInfo.isComplete(cInfo.print(id), false);
		return "refresh";
	}
}
