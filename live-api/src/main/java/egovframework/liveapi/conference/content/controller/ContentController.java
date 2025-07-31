package egovframework.liveapi.conference.content.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/conference/content")
@RequiredArgsConstructor
@Tag(name = "회의 콘텐츠 API", description = "회의 콘텐츠 관리 관련 API")
public class ContentController {


}
