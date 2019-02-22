package org.zerock.book;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService service;
	
	//Ãß°¡Æû
	@GetMapping("/register")
	public void register() {
	}
	
	//Ãß°¡
	@PostMapping("/register")
	public String register(BoardVO board) {
		service.register(board);
		return "redirect:/board/list";
	}

}
