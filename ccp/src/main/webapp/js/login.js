ccp.model.data.LoginModel = function(dataModel) {
	var self = this;
	self.userId = ko.observable(dataModel.userId);
	self.pwd = ko.observable(dataModel.pwd);
	//self.messages =  ko.observableArray(dataModel.messages);
	self.baseDomain = ko.observable(new ccp.model.data.BaseDomain(dataModel));
}

ccp.vm.LoginViewModel = function() {
	var self = this;
	var empty = {
			userId : "",
			pwd : "",
			baseDomain : null
	};

	self.dataModel = new ccp.model.data.LoginModel(empty);
	self.handler = new ccp.vm.ErrorViewModel();
	self.messages = ko.observableArray();

	self.processing = {
		doNext : false
	};

	self.bind = function() {
		ko.applyBindings(self); // This makes Knockout get to work
	};

	self.doNext = function() {
		if (self.processing.doNext) {
			return;
		}
		self.processing.doNext = true;
		var u = ROOT_NAME + '/login/next';
		$.ajax({
			type : 'POST',
			url : u,
			data : toJSON(self.dataModel),
			contentType: 'application/json',
			datatype: 'json',
			scriptCharset: 'utf-8'
		}).done(function(response) {

			Utils.changeViewing("front/topMenu.html");

		}).fail(function(xhr, exception) {
			self.handler.handle(xhr, exception);
			self.dataModel.baseDomain().messages(self.handler.errors);
		}).always(function() {
			self.processing.doNext = false;
		});
	};



};