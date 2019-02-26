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
	
	//�߰���
	@GetMapping("/register")
	public void register() {
	}
	
	//�߰�
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) { //rttr �̰Ŵ� ���� �ѹ��� �ѱ�°�ü
		logger.info("�߰���...");
		service.register(board); //�ؿ����� �����
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	//��ü����
	@GetMapping("/list")
//	public void list(Model model) {
//		logger.info("list...");
//		int total = service.getTotal();
//		model.addAttribute("total",total);
//		model.addAttribute("list",service.getList());	
//		//return ���� default�� ���ΰ��� mapping�� list.jsp �� ã���� servlet-context.xml�������س���
//	}
	public void list(Criteria cri, Model model) {
		logger.info("list:" + cri);
		model.addAttribute("list",service.getList(cri));
		int total=service.getTotal(cri);
		page.paging(cri,total);
		model.addAttribute("pageMaker",page);
		model.addAttribute("total",total);
	}
	
	//�󼼺���,���� 
	@GetMapping({"/get","/modify"}) //get�̵� modify�� �Ѵ� �Ϸ� ���� �����
	public void get(@RequestParam("bno") Long bno, Model model) {
		logger.info("get or modify....");
		model.addAttribute("board",service.get(bno)); 		//return ���� default�� ���ΰ��� mapping�� list.jsp �� ã���� servlet-context.xml�������س���
	}
	
	//�����ϱ�
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		logger.info("modify:" + board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	//�����ϱ�
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		logger.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}


		return "redirect:/book/board/list";
	}

}
