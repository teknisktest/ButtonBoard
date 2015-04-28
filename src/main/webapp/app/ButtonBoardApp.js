// Here's my data model
var ButtonBoardViewModel = function() {
    var self = this;
    self.firstName = ko.observable();
    self.lastName = ko.observable();
    self.btn2_konsulenter = ko.observableArray();
    self.btn3_response = ko.observable();
    self.btn5_response = ko.observable();
    self.btn6_crapComputing = ko.observable(1);
    self.btn7_crapComputing = ko.observable();
    self.btn8_olaQuote = ko.observableArray();


    self.sayHello = function(){
        console.log("Hello tester!");
    }

    self.btn2_hentKonsulenter = function(){
        $.ajax({
            url: "/konsulent",
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            mimeType: 'application/json',
            success: function(data) {
                $.each(data, function(id, konsulentJson){
                    self.btn2_konsulenter.push(new Konsulent(konsulentJson))
                });
            },
            error:function(data,status,er) {
                //alert("En teknisk feil oppstod - kunne ikke hente n");
            }
        });
    }

    self.btn3_getText = function(){
        $.ajax({
            url: "/noetekst",
            type: 'GET',
            mimeType: 'text/plain',
            success: function(data) {
                self.btn3_response(data);
            },
            error:function(data,status,er) {
                console.log(er);
            }
        });
    }

    self.btn5_getError = function(){
        $.ajax({
            url:"/maketrouble",
            type:'GET',
            mimeType:'text/pain',
            success: function(data) {
                self.btn5_response(data);
            },
            error:function(data,status,er) {
                console.log(er);

            }
        });
    }


    self.btn6_computeANumber = function(){

        for (i = 0; i < 100000; i++) {
            self.btn6_crapComputing(self.btn6_crapComputing() + i);
        }
    }


    self.btn7_computeAnotherNumber = function(){


        $.ajax({
            url:"/crapComputing",
            type:'GET',
            mimeType:'text/pain',
            success: function(data) {
                self.btn7_crapComputing(data);
            },
            error:function(data,status,er) {
                console.log(er);

            }
        });
    }

    self.btn8_getOlaQuote = function() {
       self.btn8_olaQuote.push("Let's git real!");
       self.btn8_olaQuote.push("Emilie: Ola jeg har 24 problemer?!? Ola: Er det ikke 99?!");
       self.btn8_olaQuote.push("Jeg er skikkelig 1337!");
        }

};

var VM = ko.applyBindings(new ButtonBoardViewModel());