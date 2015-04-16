function Konsulent(data) {
    "use strict";
    var self = this;
    self.id = ko.observable();
    self.navn = ko.observable();
    self.epost = ko.observable();
    self.image_url = ko.observable();
    self.pris = ko.observable();
    self.stilling = ko.observable();

    if(data != undefined && data != null){
        self.id(data.id);
        self.navn(data.navn);
        self.epost(data.epost);
        self.image_url(data.image_url);
        self.pris(data.pris);
        self.stilling(data.stilling);
    }


}