package prueb

class DaleController {

    def index() { }

    def sect(){
        render template: 'section', model: [marca: 'kathe']
    }
}
