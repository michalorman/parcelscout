package pl.michalorman.parcelscout.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.michalorman.parcelscout.core.factory.PackagePositionResolverFactory;
import pl.michalorman.parcelscout.core.service.PackagePositionResolver;

@Controller
@RequestMapping("/packageSearch")
public class PackageController {
    private static final Logger logger = LoggerFactory.getLogger(PackageController.class);

    @Autowired
    private PackagePositionResolverFactory packagePositionResolverFactory;

    @RequestMapping(method = RequestMethod.GET)
    public void resolvePackagePosition(@RequestParam String carrierId, @RequestParam Integer packageId, Model model) {
        logger.info("Package position requested for carrierId: '{}' and packageId: '{}'", carrierId, packageId);
        PackagePositionResolver resolver = packagePositionResolverFactory.createPackagePositionResolver(carrierId);
        resolver.resolvePackagePosition(packageId);
    }

}
