// Here's my data model
var ButtonBoardViewModel = function() {
    var self = this;
    self.firstName = ko.observable();
    self.lastName = ko.observable();
    self.btn2_konsulenter = ko.observableArray();
    self.btn3_response = ko.observable();
    self.btn5_response = ko.observable();
    self.btn6_crapComputing = ko.observable(1);


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

};

var VM = ko.applyBindings(new ButtonBoardViewModel());