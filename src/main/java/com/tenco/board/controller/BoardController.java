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
	 * 주소 설계 : localhost:8080/board/create
	 * @return create.jsp
	 */
	@GetMapping("/create")
	public String createPage() {
		return "board/create";
	}
	
	/**
	 * 게시글 작성 로직
	 * @param boardDTO
	 * @return list.jsp
	 */
	@PostMapping("/create")
	public String createBoardProc(BoardDTO boardDTO) {
		boardService.createBoard(boardDTO);
		return "redirect:/board/list";
	}
	
	/**
	 * 게시글 리스트 보기
	 * 주소 설계 : localhost:8080/board/list
	 * @return list.jsp
	 */
	@GetMapping("/list")
	public String listPage(Model model,@RequestParam(name = "page" , defaultValue = "1") int page, @RequestParam(name = "size" , defaultValue = "5") int size) {
		int offset = (page - 1) * size;
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

	/**
	 * 게시글 수정 페이지
	 * @param model
	 * @param boardId
	 * @return update.jsp
	 */
	@GetMapping("/update/{boardId}")
	public String updatePage(Model model,@PathVariable(name="boardId") Integer boardId) {
		Board board = boardService.viewBoard(boardId);
		model.addAttribute("board",board);
		return "board/update";
	}
	
	/**
	 * 게시글 수정 로직
	 * @param boardDTO
	 * @return
	 */
	@PostMapping("/update")
	public String postMethodName(BoardDTO boardDTO) {
		System.out.println("수정할 값 : " + boardDTO);
		boardService.updateBoard(boardDTO);
		return "redirect:/board/list";
	}
	
	/**
	 * 게시글 삭제 로직
	 * @param boardId
	 * @return
	 */
	@GetMapping("/delete/{boardId}")
	public String delete(@PathVariable(name="boardId") Integer boardId) {
		boardService.deleteBoard(boardId);
		return "redirect:/board/list";
	}
	
}
