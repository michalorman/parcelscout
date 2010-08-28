package pl.michalorman.spu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.michalorman.spu.model.TrackResponse;
import pl.michalorman.spu.service.PackageTrackService;

@Controller
public class ParcelController {

	@Autowired
	private PackageTrackService parcelService;

	@RequestMapping(value = "/track/{packageId}", method = RequestMethod.GET)
	public ModelAndView getParcelPosition(@PathVariable Integer packageId) {
		TrackResponse response = parcelService.getTrackInfo(packageId);
		return new ModelAndView("responseXmlView", "response", response);
	}

}
