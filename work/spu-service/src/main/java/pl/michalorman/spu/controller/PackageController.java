package pl.michalorman.spu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.michalorman.spu.api.TrackResponse;
import pl.michalorman.spu.service.PackageTrackService;

@Controller
public class PackageController {

    private Logger logger = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackageTrackService parcelService;

    @RequestMapping(value = "/track", method = RequestMethod.GET)
    public void getPackageTrackInfo(@RequestParam Integer packageId, Model model) {
        logger.info("Get track info for package: '{}'", packageId);
        TrackResponse response = parcelService.getTrackInfo(packageId);
        model.addAttribute("response", response);
    }

}
