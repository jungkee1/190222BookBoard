package org.zerock.book;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	@Autowired
	private PageDTO page;
	
	//추가폼
	@GetMapping("/register")
	public void register() {
	}
	
	//추가
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) { //rttr 이거는 값을 한번만 넘기는객체
		logger.info("추가폼...");
		service.register(board); //밑에껄로 대신함
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	//전체보기
	@GetMapping("/list")
//	public void list(Model model) {
//		logger.info("list...");
//		int total = service.getTotal();
//		model.addAttribute("total",total);
//		model.addAttribute("list",service.getList());	
//		//return 없이 default면 위로가서 mapping의 list.jsp 를 찾도록 servlet-context.xml에설정해놨음
//	}
	public void list(Criteria cri, Model model) {
		logger.info("list:" + cri);
		model.addAttribute("list",service.getList(cri));
		int total=service.getTotal(cri);
		page.paging(cri,total);
		model.addAttribute("pageMaker",page);
		model.addAttribute("total",total);
	}
	
	//상세보기,수정 
	@GetMapping({"/get","/modify"}) //get이든 modify든 둘다 일로 오게 만든다
	public void get(@RequestParam("bno") Long bno, Model model) {
		logger.info("get or modify....");
		model.addAttribute("board",service.get(bno)); 		//return 없이 default면 위로가서 mapping의 list.jsp 를 찾도록 servlet-context.xml에설정해놨음
	}
	
	//수정하기
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		logger.info("modify:" + board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	//삭제하기
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		logger.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}


		return "redirect:/book/board/list";
	}

}
