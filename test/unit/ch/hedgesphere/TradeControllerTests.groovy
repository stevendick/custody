package ch.hedgesphere



import org.junit.*
import grails.test.mixin.*

@TestFor(TradeController)
@Mock(Trade)
class TradeControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/trade/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tradeInstanceList.size() == 0
        assert model.tradeInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tradeInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tradeInstance != null
        assert view == '/trade/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/trade/show/1'
        assert controller.flash.message != null
        assert Trade.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/trade/list'

        populateValidParams(params)
        def trade = new Trade(params)

        assert trade.save() != null

        params.id = trade.id

        def model = controller.show()

        assert model.tradeInstance == trade
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/trade/list'

        populateValidParams(params)
        def trade = new Trade(params)

        assert trade.save() != null

        params.id = trade.id

        def model = controller.edit()

        assert model.tradeInstance == trade
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/trade/list'

        response.reset()

        populateValidParams(params)
        def trade = new Trade(params)

        assert trade.save() != null

        // test invalid parameters in update
        params.id = trade.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/trade/edit"
        assert model.tradeInstance != null

        trade.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/trade/show/$trade.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        trade.clearErrors()

        populateValidParams(params)
        params.id = trade.id
        params.version = -1
        controller.update()

        assert view == "/trade/edit"
        assert model.tradeInstance != null
        assert model.tradeInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/trade/list'

        response.reset()

        populateValidParams(params)
        def trade = new Trade(params)

        assert trade.save() != null
        assert Trade.count() == 1

        params.id = trade.id

        controller.delete()

        assert Trade.count() == 0
        assert Trade.get(trade.id) == null
        assert response.redirectedUrl == '/trade/list'
    }
}
