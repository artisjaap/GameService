package be.qnh.gameservice.gameservice.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDomain {

    @Autowired
    private GameProvider gameProvider;

    @Autowired
    private PublisherProvider publisherProvider;

    @Autowired
    private StoreItemProvider storeItemProvider;

    @Autowired
    private SupplierProvider supplierProvider;

    @Autowired
    private CustomerProvider customerProvider;

    @Autowired
    private CustomerGameProvider customerGameProvider;




    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerGameRepository customerGameRepository;

    @Test
    public void testDomain() {
        //create some test publishers
        Publisher mb = publisherProvider.initNewPublisher().withName("MB").getEntity();
        Publisher cartamundi = publisherProvider.initNewPublisher().withName("Cartamundi").getEntity();

        //create some games and assign the publisher for the game
        Game mikado = gameProvider.initNewGame(mb).getEntity();
        Game koningKokos = gameProvider.initNewGame(mb).getEntity();

        Game ace = gameProvider.initNewGame(cartamundi).getEntity();
        Game starwars = gameProvider.initNewGame(cartamundi).getEntity();
        Game casinoRoyale = gameProvider.initNewGame(cartamundi).getEntity();

        //create some suppliers
        Supplier fun = supplierProvider.initNewSupplier().withName("Fun").getEntity();
        Supplier dreamland = supplierProvider.initNewSupplier().withName("dreanland").getEntity();


        //create store items which are games and theire supplier, the defined price is in eurocent!
        StoreItem aceFun = storeItemProvider.initNewStoreItem(ace, fun).withPriceInEurocent(1000).getEntity();
        StoreItem mikadoFun = storeItemProvider.initNewStoreItem(mikado, fun).withPriceInEurocent(1550).getEntity();
        StoreItem mikadoDreamland = storeItemProvider.initNewStoreItem(mikado, dreamland).withPriceInEurocent(1450).getEntity();
        StoreItem casinoRoyaleDreamland = storeItemProvider.initNewStoreItem(casinoRoyale, dreamland).withPriceInEurocent(7050).getEntity();

        //customers
        Customer stijn = customerProvider.initNewCustomer().withFirstName("Stijn").getEntity();
        Customer miel = customerProvider.initNewCustomer().withFirstName("Miel").getEntity();

        //games owned by customers
        customerGameProvider.initNewCustomerGame(stijn, ace).getEntity();
        customerGameProvider.initNewCustomerGame(stijn, casinoRoyale).getEntity();
        customerGameProvider.initNewCustomerGame(miel, casinoRoyale).getEntity();
        customerGameProvider.initNewCustomerGame(miel, koningKokos).getEntity();
        customerGameProvider.initNewCustomerGame(miel, starwars).getEntity();

        Assert.assertThat(gameRepository.findAll().size(), is(5));
        Assert.assertThat(publisherRepository.findAll().size(), is(2));
        Assert.assertThat(supplierRepository.findAll().size(), is(2));
        Assert.assertThat(customerRepository.findAll().size(), is(2));
        Assert.assertThat(customerGameRepository.findAll().size(), is(5));
    }
}
