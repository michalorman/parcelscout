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

    //-----------------------------------------
    //	Resolve response format by extension
    //-----------------------------------------

    @RequestMapping(value = "/track.xml", method = RequestMethod.GET)
    public String getPackagePositionInXml(@RequestParam Integer packageId, Model model) {
        logger.info("Received request for /track.xml with params: packageId='{}'", packageId);
        addPackageToModel(packageId, model);
        return "responseXmlView";
    }

    @RequestMapping(value = "/track.json", method = RequestMethod.GET)
    public String getPackagePositionInJson(@RequestParam Integer packageId, Model model) {
        logger.info("Received request for /track.json with params: packageId='{}'", packageId);
        addPackageToModel(packageId, model);
        return "responseJsonView";
    }

    //--------------------------------------------
    //	Resolve response format by Content-Type
    //--------------------------------------------

    @RequestMapping(value = "/track", method = RequestMethod.GET, headers = "content-type=application/xml")
    public String trackPackagePositionInXml(@RequestParam Integer packageId, Model model) {
        logger.info("Received request for /track with content-type=application/xml and params: packageId='{}'",
                packageId);
        addPackageToModel(packageId, model);
        return "responseXmlView";
    }

    @RequestMapping(value = "/track", method = RequestMethod.GET, headers = "content-type=application/json")
    public String trackPackagePositionInJson(@RequestParam Integer packageId, Model model) {
        logger.info("Received request for /track with content-type=application/json and params: packageId='{}'",
                packageId);
        addPackageToModel(packageId, model);
        return "responseJsonView";
    }

    private void addPackageToModel(Integer packageId, Model model) {
        TrackResponse response = parcelService.getTrackInfo(packageId);
        model.addAttribute("response", response);
    }

}
