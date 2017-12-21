
cpp.model.data.PrpoertiesModel = function(dataModel) {
	var self = this;
	self.profile =  ko.observable(dataModel.profile);
	self.stgfile =  ko.observable(dataModel.stgfile);
}


ccp.vm.ProVsStgViewModel = function() {

	var self = this;
	var empty = {
			profile : null,
			stgfile : null

	};

	self.processing = {
			doCmp : false
		};


	self.prpoertiesModel = new cpp.model.data.PrpoertiesModel(empty);

	self.messages = ko.observableArray();
	self.handler = new ccp.vm.ErrorViewModel();


	self.doCmp = function() {
		if (self.processing.doCmp) {
			return;
		}
		self.processing.doCmp = true;

		var u = ROOT_NAME + '/tools/proVsStg/cmp';

		var fd = new FormData();
		fd.append("file[]", self.prpoertiesModel.profile());
		fd.append("file[]", self.prpoertiesModel.stgfile());

		$.ajax({
			type : 'POST',
			async: false,
			url : fd,
			enctype : 'multipart/form-data',
			processData : false,
			contentType: false,
			datatype: 'json',
			scriptCharset: 'utf-8'
		}).done(function(response) {

		}).fail(function(xhr, exception) {
			self.messages.removeAll();
			self.handler.handle(xhr, exception);
			self.messages(self.handler.errors);
		}).always(function() {
			self.processing.doLoad = false;
		});


	};




	self.bind = function() {
		ko.applyBindings(self); // This makes Knockout get to work
	};

};