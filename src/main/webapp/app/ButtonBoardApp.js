// Here's my data model
var ButtonBoardViewModel = function() {
    var self = this;
    self.firstName = ko.observable();
    self.lastName = ko.observable();
    self.btn2_konsulenter = ko.observableArray();


    self.sayHello = function(){
        console.log("Hello tester!");
    }

    self.hentKonsulenter = function(){
        
    }

};

ko.applyBindings(new ButtonBoardViewModel());