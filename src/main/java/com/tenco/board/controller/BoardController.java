package com.tenco.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.board.dto.BoardDTO;
import com.tenco.board.repository.model.Board;
import com.tenco.board.service.BoardService;

import lombok.RequiredArgsConstructor;





@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	/**
	 * 게시글 작성 페이지
	 * @return create.jsp
	 */
	@GetMapping("/create")
	public String createPage() {
		return "board/create";
	}
	
	@PostMapping("/create")
	public String createBoardProc(BoardDTO boardDTO) {
		boardService.createBoard(boardDTO);
		return "redirect:/board/list";
	}
	
	/**
	 * 게시글 리스트 보기
	 * @return list.jsp
	 */
	@GetMapping("/list")
	public String listPage(Model model,@RequestParam(name = "page" , defaultValue = "1") int page, @RequestParam(name = "size" , defaultValue = "5") int size) {
		System.out.println("********************");
		System.out.println("페이지 받기 : " + page);
		int offset = (page - 1) * size;
		System.out.println("오프셋 : " + offset);
		List<Board> boardList = boardService.readAllBoardList(size,offset);
		int totalBoard = boardService.countAllBoard();
		int totalPages = (int)Math.ceil((double)totalBoard/size); 
		if(boardList.isEmpty()) {
			model.addAttribute("boardList", null);
		}else {
			model.addAttribute("boardList",boardList);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("currentPage", page);
			model.addAttribute("size", size);
		}
		
		return "board/list";
	}
	
	/**
	 * 게시글 상세보기 페이지
	 * @return view.jsp
	 */
	@GetMapping("/view/{boardId}")
	public String viewPage(Model model,@PathVariable(name = "boardId") Integer boardId) {
		Board board = boardService.viewBoard(boardId);
		model.addAttribute("board",board);
		System.out.println("내려주는 모델 : "+board);
		return "board/view";
	}

	@GetMapping("/update/{boardId}")
	public String updatePage(Model model,@PathVariable(name="boardId") Integer boardId) {
		Board board = boardService.viewBoard(boardId);
		model.addAttribute("board",board);
		return "board/update";
	}
	
	@PostMapping("/update")
	public String postMethodName(BoardDTO boardDTO) {
		System.out.println("수정할 값 : " + boardDTO);
		boardService.updateBoard(boardDTO);
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete/{boardId}")
	public String delete(@PathVariable(name="boardId") Integer boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:/board/list";
	}
	
}
