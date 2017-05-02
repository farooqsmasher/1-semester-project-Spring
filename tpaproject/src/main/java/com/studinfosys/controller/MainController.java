package com.studinfosys.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.email.util.EmailUtil;
import com.studinfosys.entity.Download;
import com.studinfosys.entity.RoleMaster;
import com.studinfosys.entity.TblUser;
import com.studinfosys.entity.TblUserRole;
import com.studinfosys.entity.UploadFile;
import com.studinfosys.service.DownloadService;
import com.studinfosys.service.FileService;
import com.studinfosys.service.RoleMasterService;
import com.studinfosys.service.TblUserRoleService;
import com.studinfosys.service.TblUserService;
import com.studinfosys.vo.TblUserVO;
import com.tpa.util.AES;
import com.tpa.util.FileUtil;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	RoleMasterService roleMasterService;

	@Autowired
	TblUserRoleService tblUserRoleService;

	@Autowired
	TblUserService tblUserService;

	@Autowired
	FileService fileService;

	@Autowired
	DownloadService downloadService;

	@Value("${files_location}")
	private String filesLocation;

	@Value("${gmail_username}")
	private String gmailUsername;

	@Value("${gmail_password}")
	private String gmailPassword;

	public String getFilesLocation() {
		return filesLocation;
	}

	public void setFilesLocation(String filesLocation) {
		this.filesLocation = filesLocation;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model, HttpSession session, HttpServletRequest request) {

		return "login";
	}

	@RequestMapping(value = "/tpalogin", method = RequestMethod.GET)
	public String tpalogin(ModelMap model, HttpSession session, HttpServletRequest request) {

		return "tpalogin";
	}

	@RequestMapping(value = "/serverlogin", method = RequestMethod.GET)
	public String serverlogin(ModelMap model, HttpSession session, HttpServletRequest request) {

		return "serverlogin";
	}

	//this method is used to register new user
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(ModelMap model, HttpSession session, HttpServletRequest request) {
		TblUser tblUser = new TblUser();
		TblUserRole tblUserRole = new TblUserRole();
		tblUser.setUsername(request.getParameter("regUsername"));
		tblUser.setEmail(request.getParameter("regEmail"));
		tblUser.setPassword(request.getParameter("regPassword"));
		tblUser.setDesignation(request.getParameter("regdesig"));

		tblUser.setEnabled(1);
		RoleMaster roleMaster = new RoleMaster();
		roleMaster.setRoleId("ROLE_USER");
		tblUserRole.setRoleMaster(roleMaster);

		try {
			tblUserService.doAddTblUser(tblUser);
			tblUserRole.setTblUser(tblUser);
			tblUserRoleService.doAddTblUserRole(tblUserRole);
		} catch (Exception e) {
			model.addAttribute("duplicateUSer", "Y");
			return "login";
		}
		return "registrationSuccess";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String defaultPage21(ModelMap model, @ModelAttribute(value = "tblUserVO") TblUserVO tblUserVO,
			BindingResult result) {

		model.addAttribute("pageName", "childProfile");
		try {
			TblUser tblUser = tblUserVO.getTblUser();
			tblUser.setEnabled(1);
			TblUserRole tblUserRole = tblUserVO.getTblUserRole();
			tblUserRole.setTblUser(tblUserVO.getTblUser());

			tblUserService.doAddTblUser(tblUser);
			tblUserRoleService.doAddTblUserRole(tblUserRole);

			model.addAttribute("insertFlag", "true");
			model.addAttribute("tblUserVO", new TblUserVO());
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("insertFlag", "false");
		}
		model.addAttribute("usersList", tblUserService.doGetAllTblUser());
		return "usersList";
	}

	@RequestMapping(value = "/employeeUpdate", method = RequestMethod.GET)
	public String defaultPage13(ModelMap model, HttpServletRequest request) {
		TblUserVO tblUserVO = new TblUserVO();
		if (request.getParameter("id") != null) {

			try {

				TblUser tblUser = tblUserService.doGetTblUserByUserName(request.getParameter("id"));
				tblUserVO.setTblUser(tblUser);
				for (TblUserRole tblUserRole : tblUser.getTblUserRoles()) {
					tblUserVO.setTblUserRole(tblUserRole);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		model.addAttribute("tblUserVO", tblUserVO);
		model.addAttribute("roles", roleMasterService.doGetAllRoleMaster());

		return "employee";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdenied(ModelMap model, HttpSession session) {
		model.addAttribute("accesserror", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		model.addAttribute("logout", "true");

		return "login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		try {
			TblUser tblUser = tblUserService.doGetTblUserByUserName(name);
			session.setAttribute("userDetails", tblUser);
			long h12 = Math.round(Math.random() * 89999) + 10000;
			System.out.println("The unique ID is-->" + h12);

		} catch (Exception e) {

		}
		model.addAttribute("pageName", "dashBoard");
		return "home";
	}

	@RequestMapping(value = "/tpahome", method = RequestMethod.GET)
	public String tpahome(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		try {
			TblUser tblUser = tblUserService.doGetTblUserByUserName(name);
			session.setAttribute("userDetails", tblUser);

		} catch (Exception e) {

		}
		model.addAttribute("pageName", "dashBoard");
		return "tpahome";
	}

	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public String userDetails(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); // get logged in username
		try {
			TblUser tblUser = tblUserService.doGetTblUserByUserName(name);
			session.setAttribute("userDetails", tblUser);
		} catch (Exception e) {

		}

		model.addAttribute("pageName", "dashBoard");
		return "userDetails";

	}

	@RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
	public String userUpdate(ModelMap model, HttpSession session) {
		TblUser tblUser = new TblUser();

		return "userUpdate";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String welcome(Model model, HttpSession session) {
		return "fileUpload";
	}

	@RequestMapping(value = "/cloudFilesList", method = RequestMethod.GET)
	public String fileList(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		model.addAttribute("filesList", fileService.doGetVerfiedFilesByUser(auth.getName()));
		return "cloudFilesList";
	}

	@RequestMapping(value = "/allUsersList", method = RequestMethod.GET)
	public String allUsersList(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());

		model.addAttribute("usersList", fileService.doGetVerfiedFilesByUser(auth.getName()));
		return "allUsersList";
	}

	@RequestMapping(value = "/requestFile", method = RequestMethod.GET)
	public String requestFile(HttpServletRequest request, HttpSession session) {
		System.out.println(request.getParameter("id"));
		UploadFile uploadFile = fileService.doGetFileById(Integer.parseInt(request.getParameter("id")));
		uploadFile.setStatus("requested");
		fileService.doAddFile(uploadFile);
		return "redirect:sharedFilesList";
	}

	@RequestMapping(value = "/sharedFilesList", method = RequestMethod.GET)
	public String sharedfilesList(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		model.addAttribute("filesList", fileService.doGetNotVerfiedFilesByUser(auth.getName()));
		return "sharedFilesList";
	}

	@RequestMapping(value = "/userRequestedFile", method = RequestMethod.GET)
	public String userRequestedFile(ModelMap model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("filesList", fileService.doGetRequestedFilesByUser(auth.getName()));
		return "userRequestedFile";
	}

	@RequestMapping(value = "/tpaHashkey", method = RequestMethod.GET)
	public String tpaHashkey(ModelMap model, HttpSession session) {
		model.addAttribute("filesList", fileService.doGetVerifiedFiles());
		return "tpaHashkey";
	}

	@RequestMapping(value = "/allUserFilesList", method = RequestMethod.GET)
	public String allUserFilesList(ModelMap model, HttpSession session) {
		model.addAttribute("filesList", fileService.doGetVerifiedFiles());
		return "allUserFilesList";
	}

	@RequestMapping(value = "/adminRequestedFilesList", method = RequestMethod.GET)
	public String adminRequestedFilesList(ModelMap model, HttpSession session) {
		model.addAttribute("filesList", fileService.doGetRequestedFiles());
		return "adminRequestedFilesList";
	}

	@RequestMapping(value = "/userTransactions", method = RequestMethod.GET)
	public String userTransactions(ModelMap model, HttpSession session) {
		model.addAttribute("filesList", downloadService.doGetAllDownloads());
		return "userTransactions";
	}

	@RequestMapping(value = "/adminStatistics", method = RequestMethod.GET)
	public String adminStatistics(ModelMap model, HttpSession session) {
		Set<String> uniqueUsers = new HashSet<String>();
		List<String> userDownloadCount = new ArrayList<String>();
		for (Download ite : downloadService.doGetAllDownloads()) {
			uniqueUsers.add(ite.getTblUser().getUsername());
		}

		for (String ite : uniqueUsers) {
			int i = 0;
			for (Download ite1 : downloadService.doGetAllDownloads()) {
				if (ite.equals(ite1.getTblUser().getUsername())) {
					i++;
				}

			}
			userDownloadCount.add(ite + "," + i);
		}

		model.addAttribute("userDownloadCount", userDownloadCount);
		return "adminStatistics";
	}

	
	@RequestMapping(value = "/tpaStatistics", method = RequestMethod.GET)
	public String tpaStatistics(ModelMap model, HttpSession session) {
		Set<String> uniqueUsers = new HashSet<String>();
		List<String> userDownloadCount = new ArrayList<String>();
		List<UploadFile> uploadFile = fileService.doGetAllFiles(); 
		
		for (UploadFile ite : uploadFile) {
			uniqueUsers.add(ite.getTblUser().getUsername());
		}

		for (String ite : uniqueUsers) {
			int i = 0;
			int j = 0;
			for (UploadFile ite1 : uploadFile) {
				if (ite.equals(ite1.getTblUser().getUsername()) && ite1.getStatus().equals("ok")) {
					i++;
				}else{
					j++;
				}

			}
			userDownloadCount.add(ite + "," + j+ "," + i);
		}

		model.addAttribute("userDownloadCount", userDownloadCount);
		return "tpaStatistics";
	}
	
	
	@RequestMapping(value = "/tpaRequestedFilesList", method = RequestMethod.GET)
	public String tpaRequestedFilesList(ModelMap model, HttpSession session) {
		model.addAttribute("filesList", fileService.doGetRequestedOrNotVerifiedFiles());
		return "tpaRequestedFilesList";
	}

	@RequestMapping(value = "/usersList", method = RequestMethod.GET)
	public String usersList(ModelMap model, HttpSession session) {
		model.addAttribute("usersList", tblUserService.doGetAllTblUser());

		return "usersList";
	}

	@RequestMapping(value = "/ackFile", method = RequestMethod.GET)
	public String tpaRequestedFilesList(HttpServletRequest request, HttpSession session) {
		System.out.println(request.getParameter("id"));
		UploadFile uploadFile = fileService.doGetFileById(Integer.parseInt(request.getParameter("id")));
		uploadFile.setStatus("ok");
		fileService.doAddFile(uploadFile);
		return "redirect:tpaRequestedFilesList";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String Upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		String name = request.getParameter("fileDesc");
		if (!file.isEmpty()) {
			try {
				// Generating hash key
				String chars = "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
				final int PW_LENGTH = 32;
				Random rnd = new SecureRandom();
				StringBuilder pass2 = new StringBuilder();
				for (int i = 0; i < PW_LENGTH; i++)
					pass2.append(chars.charAt(rnd.nextInt(chars.length())));
				String h1 = pass2.toString();

				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				System.out.println(auth.getName());

				UploadFile uploadFile = new UploadFile();
				uploadFile.setRandomKey(h1);
				uploadFile.setSecretKey(new AES().generateSecretKey());
				System.out.println("enrypted key == " + new AES().encrypt(h1, uploadFile.getSecretKey()));
				uploadFile.setName(file.getOriginalFilename());
				uploadFile.setDescription(name);
				uploadFile.setStatus("not_verified");
				TblUser tblUser = new TblUser();
				tblUser.setUsername(auth.getName());
				uploadFile.setTblUser(tblUser);
				fileService.doAddFile(uploadFile);
				// Create the file on server
				byte[] bytes = file.getBytes();
				File serverFile = new File(getFilesLocation() + uploadFile.getId() + ".txt");
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "fileUpload";
	}

	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int BUFFER_SIZE = 4096;
		String fileName = request.getParameter("id");
		ServletContext context = request.getServletContext();
		UploadFile uploadFile = fileService.doGetFileById(Integer.parseInt(fileName));
		String fullPath = getFilesLocation() + fileName + ".txt";
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		if (request.getParameter("user") != null) {
			Download download = new Download();
			TblUser tblUser = new TblUser();
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			tblUser.setUsername(auth.getName());
			download.setTblUser(tblUser);
			download.setFile(uploadFile);
			downloadService.doAddDownload(download);
		}
		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		System.out.println(downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", uploadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}

	@RequestMapping(value = "/downloadResquestedFile", method = RequestMethod.GET)
	public String doDownloadResquested(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		int BUFFER_SIZE = 4096;
		String fileName = request.getParameter("fileId");
		String encKey = request.getParameter("encKey");

		UploadFile uploadFile = fileService.doGetFileById(Integer.parseInt(fileName));
		if (uploadFile.getRandomKey().equals(new AES().decrypt(encKey, uploadFile.getSecretKey()))) {
			ServletContext context = request.getServletContext();
			String fullPath = getFilesLocation() + fileName + ".txt";
			File downloadFile = new File(fullPath);
			FileInputStream inputStream = new FileInputStream(downloadFile);

			// get MIME type of the file
			String mimeType = context.getMimeType(fullPath);
			if (mimeType == null) {
				// set to binary type if MIME mapping not found
				mimeType = "application/octet-stream";
			}
			System.out.println("MIME type: " + mimeType);

			// set content attributes for the response
			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());

			// set headers for the response
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"", uploadFile.getName());
			response.setHeader(headerKey, headerValue);

			// get output stream of the response
			OutputStream outStream = response.getOutputStream();

			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;

			// write bytes read from the input stream into the output stream
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			model.addAttribute("errorFlag", null);
			inputStream.close();
			outStream.close();

		} else {
			model.addAttribute("errorFlag", "true");
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("filesList", fileService.doGetRequestedFilesByUser(auth.getName()));
		return "userRequestedFile";

	}

	@RequestMapping(value = "/sendKey", method = RequestMethod.GET)
	public void sendKey(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getParameter("randomKey"));
		EmailUtil emailUtil = new EmailUtil();
		emailUtil.setCredentials(gmailUsername, gmailPassword);
		try {
			emailUtil.generateAndSendGmailEmail(request.getParameter("email"), "Get Your File",
					"file name : " + request.getParameter("fileName") + " and " + "key : "
							+ new AES().encrypt(request.getParameter("randomKey"), request.getParameter("secretKey")));
		} catch (Exception e) {

		}

	}

	@RequestMapping(value = "/auditFile", method = RequestMethod.GET)
	public String auditFile(ModelMap model, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		if (request.getParameter("id") != null && request.getParameter("keywords") != null) {
			FileUtil fileUtil = new FileUtil();

			if (request.getParameter("keywords").trim().equals("")) {
				model.addAttribute("auditFlag", "Enter value in audit text field.");
			} else {
				if (fileUtil.auditFileAgainstKeywords(filesLocation + request.getParameter("id") + ".txt",
						request.getParameter("keywords"))) {
					model.addAttribute("auditFlag", "File audit - Success");
				} else {
					model.addAttribute("auditFlag", "File audit - Failed");
				}
			}

		}
		model.addAttribute("filesList", fileService.doGetRequestedOrNotVerifiedFiles());
		return "tpaRequestedFilesList";
	}

}