// Here's my data model
var ButtonBoardViewModel = function() {
    var self = this;
    self.firstName = ko.observable();
    self.lastName = ko.observable();
    self.btn2_konsulenter = ko.observableArray();


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
                $.each(data, function(konsulentJson){
                    self.btn2_konsulenter.push(new Konsulent(konsulentJson))
                });
            },
            error:function(data,status,er) {
                //alert("En teknisk feil oppstod - kunne ikke hente n");
            }
        });
    }

};

ko.applyBindings(new ButtonBoardViewModel());