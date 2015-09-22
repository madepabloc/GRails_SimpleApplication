package sample

import org.springframework.dao.DataIntegrityViolationException

class TransferenceController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [transferenceInstanceList: Transference.list(params), transferenceInstanceTotal: Transference.count()]
    }

    def create() {
        [transferenceInstance: new Transference(params)]
    }

    def save() {
        def transferenceInstance = new Transference(params)
        if (!transferenceInstance.save(flush: true)) {
            render(view: "create", model: [transferenceInstance: transferenceInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'transference.label', default: 'Transference'), transferenceInstance.id])
        redirect(action: "show", id: transferenceInstance.id)
    }

    def show(Long id) {
        def transferenceInstance = Transference.get(id)
        if (!transferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'transference.label', default: 'Transference'), id])
            redirect(action: "list")
            return
        }

        [transferenceInstance: transferenceInstance]
    }

    def edit(Long id) {
        def transferenceInstance = Transference.get(id)
        if (!transferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'transference.label', default: 'Transference'), id])
            redirect(action: "list")
            return
        }

        [transferenceInstance: transferenceInstance]
    }

    def update(Long id, Long version) {
        def transferenceInstance = Transference.get(id)
        if (!transferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'transference.label', default: 'Transference'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (transferenceInstance.version > version) {
                transferenceInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'transference.label', default: 'Transference')] as Object[],
                          "Another user has updated this Transference while you were editing")
                render(view: "edit", model: [transferenceInstance: transferenceInstance])
                return
            }
        }

        transferenceInstance.properties = params

        if (!transferenceInstance.save(flush: true)) {
            render(view: "edit", model: [transferenceInstance: transferenceInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'transference.label', default: 'Transference'), transferenceInstance.id])
        redirect(action: "show", id: transferenceInstance.id)
    }

    def delete(Long id) {
        def transferenceInstance = Transference.get(id)
        if (!transferenceInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'transference.label', default: 'Transference'), id])
            redirect(action: "list")
            return
        }

        try {
            transferenceInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'transference.label', default: 'Transference'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'transference.label', default: 'Transference'), id])
            redirect(action: "show", id: id)
        }
    }
}
