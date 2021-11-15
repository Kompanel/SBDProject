package com.sbd.sbdproject.model.processor;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/processors")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProcessorController {

  private final ProcessorService processorService;

  @GetMapping(path = "/all", params = {"page", "size"})
  public ResponseEntity<Page<Processor>> getAll(@RequestParam("page") int page,
      @RequestParam(name = "size", required = false, defaultValue = "10") int size) {

    return new ResponseEntity<>(processorService.getAll(page, size), HttpStatus.OK);
  }
}
