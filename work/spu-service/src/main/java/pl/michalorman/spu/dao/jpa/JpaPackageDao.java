package pl.michalorman.spu.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.michalorman.spu.dao.PackageDao;
import pl.michalorman.spu.model.Package;

@Repository("packageDao")
@Transactional
public class JpaPackageDao implements PackageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Package findById(Integer packageId) {
        return entityManager.find(Package.class, packageId);
    }

}
