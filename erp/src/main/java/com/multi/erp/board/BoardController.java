package com.multi.erp.board;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.multi.erp.common.FileUploadLogicService;
import com.multi.erp.member.MemberDTO;

@Controller
public class BoardController {
	BoardService service;
	FileUploadLogicService fileuploadservice;
	public BoardController() {

	}

	@Autowired
	public BoardController(BoardService service, FileUploadLogicService fileuploadservice) {
		super();
		this.service = service;
		this.fileuploadservice = fileuploadservice;
	}
	
	@GetMapping("/board/write") // boardlist.jsp에서 a태그 href속성 값이랑 똑같음 즉, 매핑을 버튼이나 링크에 해주는 것이 아닐까??
	public String writePage() {

		return "board/writepage"; // board-tiles의 name속성이랑 똑같음.
	}

	@PostMapping("/board/write")
	public String write(BoardDTO board, HttpSession session) throws IllegalStateException, IOException {
		System.out.println(board);
		//1.MultipaetFile정보를 추출
		List<MultipartFile> files = board.getFiles();
		//2.업로드될 서버의 경로 추출
		// - 실제 서버의 경로를 추출하기 위해 Context객체의 정보를 담고있는 ServletContext객체를 추출
		// - ServletContext가 우리가 웹에서 운영할 프로젝트에 대한 정보를 담고있는 객체
		//   실제경로를 구할 수 있는 메소드가 있음
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload"); //실제 추가될 경로
		System.out.println("###################");
		System.out.println(path);
		//3.업로드로직을 구현해서 업로드 되도록 처리
		List<BoardFileDTO> boardfiledtolist = fileuploadservice.uploadFiles(files, path);
		//4.게시글에 대한 일반적인 내용과 첨부파일이 있는 경우 첨부되는 파일의 정보를 담은 List<BoardFileDTO>를 db에 저장하기 위해 서비스에 전달
		service.insert(board, boardfiledtolist);  // 이렇게 함으로써 db에 값이 들어간다..??
		return "redirect:/board/list.do?category=all"; // 컨트롤러 요청재지정
	}

	@RequestMapping("/board/list.do")
	public ModelAndView list(String category) {
		System.out.println("=====" + category);
		// ModelAndView로 데이터 공유
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDTO> boardlist = service.findByCategory(category);
//		List<BoardDTO> boardlist = service.boardList();
		mav.addObject("category", category);
		mav.addObject("boardlist", boardlist);
		System.out.println(boardlist);
		return mav; // view
	}

	/*
	 * 즉, 매핑명은 버튼이나 하이퍼링크 경로 속성에, return은 view일 경우 tiles의 name속성이랑 똑같이.
	 */
	@RequestMapping("/board/search.do")
	public ModelAndView search(String tag, String search) {
		// ModelAndView로 데이터 공유
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDTO> boardlist = service.search(tag, search);
		mav.addObject("boardlist", boardlist);
		System.out.println(boardlist);
		return mav;
	}
	
	

	// 파라미터 이름 오타없이 적기. 매핑돼서 넘어오기 때문에.
	// 매개변수를 허용된 범위 안에서 적을 수 있다는 게 무슨 뜻일까??
	@RequestMapping("/board/read.do")
	public String read(String board_no, String state, Model model) {
		BoardDTO board = service.getBoardInfo(board_no);
		List<BoardFileDTO> boardfiledtolist = service.getFileList(board_no);
		String view = "";
		if (state.equals("READ")) {
			view = "board/read";
		} else {
			view = "board/update";
		}
		model.addAttribute("board", board);
		model.addAttribute("boardfiledtolist", boardfiledtolist);

		return view;
	}

	// 삭제는 인증절차를 2번한다.
	// 1.로그인이 되어있는지
	// 2.내가쓴 글인지
	// redirect: 는 클라이언트부터 다시 시작? 즉, 새로운작업을 시작하기 위해 ? view이름을 주는 경우는
	// 데이터를 공유하는 경우는 view이름만 주고
	// 전혀 새롭게 요청이 들어가는 경우 redirect: 가 들어간다,
	@RequestMapping("/board/delete.do")
	public String delete(String board_no, HttpSession session) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String view = "";
		if (user == null) { // 로그인 하지 않은상태
			view = "redirect:/emp/login.do"; // view
		} else { // 로그인이 된 상태
			int result = service.delete(board_no); // 로그인이 된 상태에서만 삭제
			view = "redirect:/board/list.do?category=all"; // action
//			view ="board/list";
		}
		return view;
	}

	@PostMapping("/board/update.do")
	public String update(BoardDTO board) {
		System.out.println(board);
		service.update(board);
		return "redirect:/board/list.do?category=all";// 컨트롤러 요청재지정
	}
	@RequestMapping("/board/download/{id}/{board_no}/{boardFileno}")
	public ResponseEntity<UrlResource> downloadFile(@PathVariable String id, @PathVariable String board_no, @PathVariable String boardFileno, HttpSession session) throws MalformedURLException, FileNotFoundException {
		System.out.println(id + "," + board_no + "," + boardFileno);
		//1.파일을 다운로드 하기 위해 디비에 저장된 파일의 정보를 가져오기 - 다운로드를 요청한 파일을 response
		BoardFileDTO selectfileInfo = service.getFile(new BoardFileDTO(board_no, "", "", boardFileno));
		//2.BoardFileDTO객체에서 다운로드할 파일의 실제 객체로 변환하는 작업
		//  UrlResource resource = new UrlResource("file:" + 파일의 full path)
//														     ---------------
//															 실제 파일이 있는 위치
		//미리 업로드된 파일을 다운로드해야 하므로 업로드된 파일이 저장된 위치와 실제 저장된 파일명을 연결해서 경로를 만들어줘야 한다.
		UrlResource resource = new UrlResource("file:" + WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload/" + selectfileInfo.getStoreFilename()));
		//3.파일명에 한글이 있는 경우 오류가 발생하지 않도록 처리 - 다운로드되는 파일명
		String encodedFilename = UriUtils.encode(selectfileInfo.getOriginalFilename(), "UTF-8");
		//4.파일을 다운로드형식으로 응답하기 위해서 응답헤더에 셋팅해줘야함 => attachment; filename="a.jpg"
		String mycontenttype = "attachment; filename=\"" + encodedFilename + "\"";
		
		//응답메시지?
//		BodyBuilder builder = ResponseEntity.ok(); ==> response가 정상처리되도록 설정(200번 응답코드를 셋팅)
		
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, mycontenttype).body(resource);
	}
	//mainContent.jsp에서 ajax로 요청될 메소드
	//=> category별 데이터만 조회해서 json Array로 json Array로 response
	@RequestMapping(value = "/board/ajax/list.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<BoardDTO> ajaxlist(String category) {
		List<BoardDTO> data = service.findByCategory(category);
		System.out.println("^^^^^^^^^^^^^^^" + data);
		return data;
	}
}
