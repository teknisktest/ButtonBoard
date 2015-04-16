function Prosjekt(data){
    "use strict";
    var self = this;
    self.id = ko.observable();
    self.konsulenter = ko.observableArray();
    self.navn = ko.observable();

    if(data != undefined && data != null){
        self.id(data.id);

        $.map(data.konsulenter, function(konsulentJson){
            self.konsulenter.push(new Konsulent(konsulentJson));
        });

        self.navn(data.navn);
    }
}