package pl.michalorman.spu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.michalorman.spu.model.Parcel;
import pl.michalorman.spu.service.ParcelService;

@Controller
public class ParcelController {

	@Autowired
	private ParcelService parcelService;

	@RequestMapping(value = "/track/{parcelId}", method = RequestMethod.GET)
	public ModelAndView getParcelPosition(@PathVariable String parcelId) {
		Parcel parcel = parcelService.getParcel(parcelId);
		ModelAndView view = new ModelAndView("parcelXmlView", BindingResult.MODEL_KEY_PREFIX + "parcel", parcel);
		return view;
	}

}
