package be.qnh.gameservice.gameservice.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SupplierProvider {
    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierMother initNewSupplier(){
        return new SupplierMother();
    }

    public class SupplierMother {
        private String name = "Publisher";

        public SupplierMother withName(String val) {
            this.name = val;
            return this;
        }

        public Supplier getEntity() {
            return supplierRepository.save(Supplier.newBuilder()
                    .withName(name)
                    .build());
        }
    }
}
