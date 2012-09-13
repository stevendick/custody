package ch.hedgesphere

import grails.converters.JSON
import grails.converters.XML

import org.springframework.dao.DataIntegrityViolationException

class TradeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        withFormat {
            html {
                [tradeInstanceList: Trade.list(params), tradeInstanceTotal: Trade.count()]
            }
            json {
                render Trade.list(params) as JSON
            }
            xml {
                render Trade.list(params) as XML
            }
        }

    }

    def create() {
        [tradeInstance: new Trade(params)]
    }

    def save() {
        def tradeInstance = new Trade(params)
        if (!tradeInstance.save(flush: true)) {
            render(view: "create", model: [tradeInstance: tradeInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'trade.label', default: 'Trade'), tradeInstance.id])
        redirect(action: "show", id: tradeInstance.id)
    }

    def show(Long id) {
        def tradeInstance = Trade.get(id)
        if (!tradeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trade.label', default: 'Trade'), id])
            redirect(action: "list")
            return
        }

        [tradeInstance: tradeInstance]
    }

    def edit(Long id) {
        def tradeInstance = Trade.get(id)
        if (!tradeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trade.label', default: 'Trade'), id])
            redirect(action: "list")
            return
        }

        [tradeInstance: tradeInstance]
    }

    //def update(Long id, Long version) {
    def update() {
        println request.getMethod()
        println request.getContentType()
        println request.getInputStream().text
        println "params: ${params}"
        def tradeInstance = Trade.get(params.id)
        if (!tradeInstance) {
            withFormat {
                html {
                    flash.message = message(code: 'default.not.found.message', args: [message(code: 'trade.label', default: 'Trade'), params.id])
                    redirect(action: "list")
                }
                json {
                    response.sendError(404)
                }
            }
            return
        }

        if (params.version != null) {
            if (tradeInstance.version > params.version) {
                tradeInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'trade.label', default: 'Trade')] as Object[],
                          "Another user has updated this Trade while you were editing")
                withFormat {
                    html {
                        render(view: "edit", model: [tradeInstance: tradeInstance])
                    }
                    json { response.sendError(409) }
                }
                return
            }
        }

        tradeInstance.properties = params
        println tradeInstance
        if (!tradeInstance.save(flush: true)) {
            println tradeInstance.errors
            withFormat {
                html { render(view: "edit", model: [tradeInstance: tradeInstance]) }

                json { response.status = 403
                       render tradeInstance.errors as JSON
                }
            }
            return
        }

        withFormat {
            html {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'trade.label', default: 'Trade'), tradeInstance.id])
                redirect(action: "show", id: tradeInstance.id)
            }
            json {
                response.status = 204
                render tradeInstance as JSON
            }
        }
    }

    def delete(Long id) {
        def tradeInstance = Trade.get(id)
        if (!tradeInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'trade.label', default: 'Trade'), id])
            redirect(action: "list")
            return
        }

        try {
            tradeInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'trade.label', default: 'Trade'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'trade.label', default: 'Trade'), id])
            redirect(action: "show", id: id)
        }
    }
}
