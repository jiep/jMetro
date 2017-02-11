package com.aebd.jMetro.app.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aebd.jMetro.metro.Metro;

@Controller
public class MetroController {
	
	private Metro m = Metro.getInstance();
	
	private List<String> stations = Arrays.asList(m.getNombreEstaciones());


    @RequestMapping("/")
    public ModelAndView home() {
    	return new ModelAndView("index").addObject("stations", stations);
    }
    
    @RequestMapping(value="/getShortestPath", method = RequestMethod.POST)
    public ModelAndView getShortestPath(@RequestParam("source") int source, @RequestParam("target") int target){
    	ModelAndView mv = new ModelAndView("index");
    	if(source == target){
    		mv.addObject("error", "Las estaciones de origen y destino no pueden coincidir");
    	}else{
    		int distance = m.getDistancia(source, target);
    		LinkedList<String> route = m.rutaMinima(source, target);

    		mv.addObject("route", route).addObject("distance", distance)
    		  .addObject("showRoute", true);
    	}
    	return mv.addObject("stations", stations);
    }
}
