// Here's my data model
var ButtonBoardViewModel = function() {
    var self = this;
    self.firstName = ko.observable();
    self.lastName = ko.observable();

    self.sayHello = function(){
        console.log("Hello tester!");
    }

};

ko.applyBindings(new ButtonBoardViewModel());