package sample



import org.junit.*
import grails.test.mixin.*

@TestFor(TransferenceController)
@Mock(Transference)
class TransferenceControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/transference/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.transferenceInstanceList.size() == 0
        assert model.transferenceInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.transferenceInstance != null
    }

    void testSave() {
        controller.save()

        assert model.transferenceInstance != null
        assert view == '/transference/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/transference/show/1'
        assert controller.flash.message != null
        assert Transference.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/transference/list'

        populateValidParams(params)
        def transference = new Transference(params)

        assert transference.save() != null

        params.id = transference.id

        def model = controller.show()

        assert model.transferenceInstance == transference
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/transference/list'

        populateValidParams(params)
        def transference = new Transference(params)

        assert transference.save() != null

        params.id = transference.id

        def model = controller.edit()

        assert model.transferenceInstance == transference
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/transference/list'

        response.reset()

        populateValidParams(params)
        def transference = new Transference(params)

        assert transference.save() != null

        // test invalid parameters in update
        params.id = transference.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/transference/edit"
        assert model.transferenceInstance != null

        transference.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/transference/show/$transference.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        transference.clearErrors()

        populateValidParams(params)
        params.id = transference.id
        params.version = -1
        controller.update()

        assert view == "/transference/edit"
        assert model.transferenceInstance != null
        assert model.transferenceInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/transference/list'

        response.reset()

        populateValidParams(params)
        def transference = new Transference(params)

        assert transference.save() != null
        assert Transference.count() == 1

        params.id = transference.id

        controller.delete()

        assert Transference.count() == 0
        assert Transference.get(transference.id) == null
        assert response.redirectedUrl == '/transference/list'
    }
}
