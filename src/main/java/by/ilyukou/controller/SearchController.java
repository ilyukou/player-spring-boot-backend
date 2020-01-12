package by.ilyukou.controller;

import by.ilyukou.domain.HttpDto;
import by.ilyukou.domain.HttpDtoResponseStatus;
import by.ilyukou.domain.Music;
import by.ilyukou.service.interfaces.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/search")
public class SearchController {

    final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }


    @GetMapping("/get")
    public HttpDto<List<Music>> get(
            @RequestParam String query
    ) {
        return new HttpDto<List<Music>>(HttpDtoResponseStatus.OK,searchService.search(query));
    }

    @GetMapping("/elastic")
    public HttpDto<List<Music>> elastic(
            @RequestParam String query
    ) {
        return new HttpDto<List<Music>>(HttpDtoResponseStatus.OK,searchService.elasticSearch(query));
    }

}
